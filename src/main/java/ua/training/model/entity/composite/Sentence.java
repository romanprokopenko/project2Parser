package ua.training.model.entity.composite;

import ua.training.model.entity.ElementOfText;
import ua.training.model.entity.SentenceElementType;
import ua.training.model.entity.leaf.LeafFactory;
import ua.training.model.entity.RegularExpression;
import ua.training.model.entity.leaf.Word;
import ua.training.model.entity.leaf.PunctuationMark;

import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of {@link AbstractCompositeElementOfText}
 * Represents sentence level of composite
 *
 * @author Roman Prokopenko
 */
public class Sentence extends AbstractCompositeElementOfText {

    /**
     * Parses through currentCompositeText using {@link RegularExpression}.
     * Creates new {@link Word} and {@link PunctuationMark}
     * objects
     *
     * @param currentCompositeText
     */
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

        /*after sentence assembled, we can remove program listing*/
        for (int i = 0; i < subElements.size(); i++) {
            if (subElements.get(i).toString().matches(RegularExpression.CODE_START_REGEXP)) {
                removeElementsToEndLine(subElements, i);
            }
        }

        /*after removing source code we can start swapping last and first words*/
        int firstIndex = findFirstWordIndex(this.subElements);
        int secondIndex = findLastWordIndex(this.subElements);
        swapListElements(this.subElements, firstIndex, secondIndex);
    }


    /**
     * Removes all elements from specified list from specified position
     * until "\n" appears
     *
     * @param list  list
     * @param index position
     */
    void removeElementsToEndLine(List<ElementOfText> list, int index) {
        ListIterator<ElementOfText> listIterator = list.listIterator(index);
        while (listIterator.hasNext()) {
            if (listIterator.next().toString().equals("\n")) {
                break;
            } else {
                listIterator.remove();
            }
        }
    }

    /**
     * Search for index of first appearance of {@link Word} element
     * in list of sub elements
     *
     * @param list list of sub elements
     * @return index
     */
    int findFirstWordIndex(List<ElementOfText> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Word) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Search for index of last appearance of {@link Word} element
     * in list of sub elements
     *
     * @param list list of sub elements
     * @return index
     */
    int findLastWordIndex(List<ElementOfText> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) instanceof Word) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Swaps two elements of list
     *
     * @param list        list
     * @param firstIndex  index of first element
     * @param secondIndex index of second element
     */
    void swapListElements(List list, int firstIndex, int secondIndex) {
        Object tmp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, tmp);
    }
}
