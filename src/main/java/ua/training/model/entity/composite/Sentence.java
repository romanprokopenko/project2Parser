package ua.training.model.entity.composite;

import ua.training.model.entity.ElementOfText;
import ua.training.model.entity.SentenceElementType;
import ua.training.model.entity.leaf.LeafFactory;
import ua.training.model.entity.RegularExpression;
import ua.training.model.entity.leaf.Word;
import ua.training.model.entity.leaf.PunctuationMark;

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
     * @param currentCompositeText text to form sentence
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
    }
}
