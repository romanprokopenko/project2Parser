package ua.training.model.entity.composite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.entity.ElementOfText;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Roman Prokopenko on 06.12.2016.
 */
public class SentenceTest {

    private Sentence sentence;

    @Before
    public void init() {
        String testString = "Во время наследования возможно изменения" +
                " модификаторов доступа в сторону большей видимости;.";
        sentence = new Sentence();
        sentence.parse(testString);
    }

    @Test
    public void findFirstWordIndex() throws Exception {
        int actualIndex = sentence.findFirstWordIndex(sentence.subElements);
        int expectedIndex = 0;
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void findLastWordIndex() throws Exception {
        int actualIndex = sentence.findLastWordIndex(sentence.subElements);
        int expectedIndex = sentence.subElements.size() - 3;
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void swapListElements() throws Exception {
        String testString = "видимости время наследования возможно" +
                " изменения модификаторов доступа в сторону большей Во;.";
        Sentence tmpSentence = new Sentence();
        tmpSentence.parse(testString);
        List<ElementOfText> expectedList = tmpSentence.subElements;

        int firstIndex = sentence.findFirstWordIndex(sentence.subElements);
        int lastIndex = sentence.findLastWordIndex(sentence.subElements);
        sentence.swapListElements(sentence.subElements, firstIndex, lastIndex);
        List<ElementOfText> actualList = sentence.subElements;

        Assert.assertEquals(expectedList, actualList);

    }

}