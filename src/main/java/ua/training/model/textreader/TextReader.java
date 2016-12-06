package ua.training.model.textreader;

import java.io.IOException;

/**
 * Created by Graffit on 06.12.2016.
 */
public interface TextReader {
    String getTextFromFile(String filePath) throws IOException;
}
