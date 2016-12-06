package ua.training.model.entity.composite;

import ua.training.model.entity.ElementOfText;
import ua.training.model.entity.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Graffit on 06.12.2016.
 */
public class Text extends AbstractCompositeElementOfText {

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
