package ua.training.model.textreader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * textReader implementation
 *
 * @author Roman Prokopenko
 */
public class ParserTextReader implements TextReader {

    /**
     * Exception String constants
     */
    private static final String FILE_NOT_EXISTS = "Specified file doesn't exist";

    /**
     * File encoding
     */
    private static final String ENCODING = "UTF-8";

    @Override
    public String getTextFromSource(String filePath) throws IOException {
        Objects.requireNonNull(filePath);
        File file = new File(getClass().getResource(filePath).getPath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file),
                                        Charset.forName(ENCODING)))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
                result.append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage() + FILE_NOT_EXISTS);
        }
        return result.toString();
    }
}
