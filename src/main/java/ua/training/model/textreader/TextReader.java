package ua.training.model.textreader;

import java.io.IOException;

/**
 * Text reader interface
 *
 * @author Roman Prokopenko
 */
public interface TextReader {
    /**
     * Returns text from specified file
     *
     * @param filePath file path
     * @return text from file as String
     * @throws IOException reading exceptions
     */
    String getTextFromSource(String filePath) throws IOException;
}
