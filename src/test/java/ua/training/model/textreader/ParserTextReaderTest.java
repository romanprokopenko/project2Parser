package ua.training.model.textreader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Roman Prokopenko on 07.12.2016.
 */
public class ParserTextReaderTest {

    private String filePath;
    private String expectedText =
            "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque\n" +
    " laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi\n" +
    " architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia\n" +
    " voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos\n" +
    " qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum\n" +
    " quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi\n" +
    " tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim\n" +
    " ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam,\n" +
    " nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui\n" +
    " in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem\n" +
    " eum fugiat quo voluptas nulla pariatur?\n";
    @Before
    public void init() {
        filePath = "test.txt";
    }
    @Test
    public void getTextFromFileTest() throws Exception {
        TextReader textReader = new ParserTextReader();
        Assert.assertEquals(expectedText,textReader.getTextFromFile(filePath));
    }

}