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

}