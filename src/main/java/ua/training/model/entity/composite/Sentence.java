package ua.training.model.entity.composite;

import ua.training.model.entity.ElementOfText;
import ua.training.model.entity.SentenceElementType;
import ua.training.model.entity.leaf.LeafFactory;
import ua.training.model.entity.RegularExpression;
import ua.training.model.entity.leaf.Word;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Graffit on 06.12.2016.
 */
public class Sentence extends AbstractCompositeElementOfText {

    @Override
    public void parse(String currentCompositeText) {
        Pattern pattern = Pattern.compile(RegularExpression.SENTENCE_REGEXP);
        Matcher matcher = pattern.matcher(currentCompositeText);
        while (matcher.find()) {
            if (matcher.group(SentenceElementType.WORD.toString()) != null) {
                ElementOfText word = LeafFactory.createWord(matcher.group(SentenceElementType.WORD.toString()));
                this.subElements.add(word);
            } else if (matcher.group(SentenceElementType.PUNCTUATION_MARK.toString()) != null) {
                ElementOfText punctuationMark = LeafFactory.createPunctuationMark(
                        matcher.group(SentenceElementType.PUNCTUATION_MARK.toString()));
                this.subElements.add(punctuationMark);
            }
        }

        int firstIndex = findFirstWordIndex(this.subElements);
        int secondIndex = findLastWordIndex(this.subElements);
        swapListElements(this.subElements, firstIndex, secondIndex);
    }

    int findFirstWordIndex(List<ElementOfText> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Word) {
                return i;
            }
        }
        return -1;
    }

    int findLastWordIndex(List<ElementOfText> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) instanceof Word) {
                return i;
            }
        }
        return -1;
    }

    void swapListElements(List list, int firstIndex, int secondIndex) {
        Object tmp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, tmp);
    }
}
