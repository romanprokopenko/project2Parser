package ua.training.model;


import ua.training.model.entity.ElementOfText;
import ua.training.model.entity.composite.Text;
import ua.training.model.textreader.ParserTextReader;
import ua.training.model.textreader.TextReader;

import java.io.IOException;

/**
 * Class which used for business-logic purposes
 *
 * @author Roman Prokopenko
 */
public class ParserModel implements Model {
    private TextReader reader = new ParserTextReader();

    private ElementOfText text = new Text();

    @Override
    public String getText(String filePath) throws IOException {
        return reader.getTextFromFile(filePath);
    }

    @Override
    public String processText(String text) {
        this.text.parse(text);
        return this.text.toString();
    }
}

