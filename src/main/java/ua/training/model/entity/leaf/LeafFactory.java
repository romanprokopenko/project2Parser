package ua.training.model.entity.leaf;

import java.util.HashMap;
import java.util.Map;

/**
 * Class which controls creation of leaf elements
 *
 * @author Roman Prokopenko
 */
public abstract class LeafFactory {

    /**
     * Map of already created {@link Word} objects
     */
    private static Map<String, Word> words = new HashMap<>();

    /**
     * Map of already created {@link PunctuationMark} objects
     */
    private static Map<String, PunctuationMark> punctuationMarks = new HashMap<>();

    /**
     * Checks if there is the same Word in Map.
     * Adds new word to Map if no. Then returns this Word
     *
     * @param wordText text of word
     * @return reference to Word object
     */
    public static Word createWord(String wordText) {
        words.putIfAbsent(wordText, new Word(wordText));
        return words.get(wordText);
    }

    /**
     * Checks if there is the same PunctuationMark in Map.
     * Adds new word to Map if no. Then returns this PunctuationMark
     *
     * @param punctuationMarkSymbol text of punctuation mark
     * @return reference to PunctuationMark object
     */
    public static PunctuationMark createPunctuationMark(String punctuationMarkSymbol) {
        punctuationMarks.putIfAbsent(punctuationMarkSymbol, new PunctuationMark(punctuationMarkSymbol));
        return punctuationMarks.get(punctuationMarkSymbol);
    }
}
