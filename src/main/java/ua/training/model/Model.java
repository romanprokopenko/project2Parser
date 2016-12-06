package ua.training.model;

import java.io.IOException;

/**
 * Model interface
 *
 * @author Roman Prokopenko
 */
public interface Model {

    /**
     * Gets text from specified file
     *
     * @param filePath file path
     * @return text of file as String
     * @throws IOException reading exceptions
     */
    String getText(String filePath) throws IOException;

    /**
     * Performs processing of specified text
     *
     * @param text text to process
     * @return processed text
     */
    String processText(String text);
}
