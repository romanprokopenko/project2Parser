package ua.training.model;

import java.io.IOException;

/**
 * Created by Graffit on 06.12.2016.
 */
public interface Model {
    String getText(String filePath) throws IOException;

    String processText(String text);
}
