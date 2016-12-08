package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.entity.ElementOfText;
import ua.training.model.entity.composite.Sentence;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Roman Prokopenko on 07.12.2016.
 */
public class ParserModelTest {
    Sentence sentence;
    ParserModel model;

    @Before
    public void init() {
        String testString = "Во время наследования возможно изменения" +
                " модификаторов доступа в сторону большей видимости;.";
        sentence = new Sentence();
        sentence.parse(testString);
        model = new ParserModel();
    }

    @Test
    public void removeCode() throws Exception {

    }

    @Test
    public void removeElementsToEndLine() throws Exception {

    }

    @Test
    public void swapListElements() throws Exception {
        String testString = "видимости время наследования возможно" +
                " изменения модификаторов доступа в сторону большей Во;.";
        Sentence tmpSentence = new Sentence();
        tmpSentence.parse(testString);
        List<ElementOfText> expectedList = tmpSentence.getSubElements();

        int firstIndex = model.findFirstWordIndex(sentence.getSubElements());
        int lastIndex = model.findLastWordIndex(sentence.getSubElements());
        model.swapListElements(sentence.getSubElements(), firstIndex, lastIndex);
        List<ElementOfText> actualList = sentence.getSubElements();

        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void findFirstWordIndex() throws Exception {
        int actualIndex = model.findFirstWordIndex(sentence.getSubElements());
        int expectedIndex = 0;
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void findLastWordIndex() throws Exception {
        int actualIndex = model.findLastWordIndex(sentence.getSubElements());
        int expectedIndex = sentence.getSubElements().size() - 3;
        Assert.assertEquals(expectedIndex, actualIndex);
    }

}