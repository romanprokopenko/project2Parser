package ua.training.model.entity.composite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.entity.ElementOfText;
import ua.training.model.entity.leaf.PunctuationMark;
import ua.training.model.entity.leaf.Word;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by Roman Prokopenko on 06.12.2016.
 */
public class SentenceTest {

    private Sentence sentence;
    String testString;

    @Before
    public void init() {
        testString = "Во время наследования возможно изменения" +
                " модификаторов доступа в сторону большей видимости;.";
        sentence = new Sentence();
        sentence.parse(testString);
    }

    @Test
    public void parseWordSizeTest() {
        int expectedSize = 11;
        int actualSize = sentence.getSubElements().stream().
                                                filter(x -> x instanceof Word).
                                                collect(Collectors.toList()).size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void parsePunctuationSizeTest() {
        int expectedSize = 12;
        int actualSize = sentence.getSubElements().stream().
                filter(x -> x instanceof PunctuationMark).
                collect(Collectors.toList()).size();
        Assert.assertEquals(expectedSize, actualSize);
    }

}