package ua.training.model.entity.composite;

import ua.training.model.entity.ElementOfText;
import ua.training.model.entity.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of {@link AbstractCompositeElementOfText}
 * Represents text (highest) level of composite
 *
 * @author Roman Prokopenko
 */
public class Text extends AbstractCompositeElementOfText {

    /**
     * Parses through currentCompositeText using {@link RegularExpression}.
     * Creates new {@link Sentence} objects
     *
     * @param currentCompositeText text to parse
     */
    @Override
    public void parse(String currentCompositeText) {
        Pattern pattern = Pattern.compile(RegularExpression.TEXT_REGEXP);
        Matcher matcher = pattern.matcher(currentCompositeText);
        while (matcher.find()) {
            ElementOfText sentence = new Sentence();
            sentence.parse(matcher.group());
            this.subElements.add(sentence);
        }
    }


}
