package ua.training.model.entity.composite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.entity.ElementOfText;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Roman Prokopenko on 07.12.2016.
 */
public class TextTest {

    private Text text;
    private String testString;

    @Before
    public void init() {
        text = new Text();
        testString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do" +
                " eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo" +
                " consequat.";
    }


    @Test
    public void parseTest() throws Exception {
        text.parse(testString);
        Assert.assertEquals(testString.split("\\.").length, text.subElements.size());
    }

    @Test
    public void parseTestEquals() {
        text.parse(testString);
        List<ElementOfText> expectedList = new ArrayList<>();
        Sentence sentence1 = new Sentence();
        sentence1.parse("Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        Sentence sentence2 = new Sentence();
        sentence2.parse(" Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                "laboris nisi ut aliquip ex ea commodo consequat.");
        expectedList.add(sentence1);
        expectedList.add(sentence2);
        Assert.assertEquals(expectedList, text.subElements);
    }

}