package ua.training.model.entity.leaf;

import ua.training.model.entity.ElementOfText;

import java.util.HashMap;
import java.util.Map;

/**
 * Class which controls creation of leaf elements
 *
 * @author Roman Prokopenko
 */
public abstract class LeafFactory {

    /**
     * Map of already created leaves
     */
    private static Map<String, ElementOfText> leaves = new HashMap<>();


    /**
     * Checks if there is the same Word in Map.
     * Adds new word to Map if no. Then returns this Word
     *
     * @param wordText text of word
     * @return reference to Word object
     */
    public static Word createWord(String wordText) {
        leaves.putIfAbsent(wordText, new Word(wordText));
        return (Word) leaves.get(wordText);
    }

    /**
     * Checks if there is the same PunctuationMark in Map.
     * Adds new word to Map if no. Then returns this PunctuationMark
     *
     * @param punctuationMarkSymbol text of punctuation mark
     * @return reference to PunctuationMark object
     */
     public static PunctuationMark createPunctuationMark(String punctuationMarkSymbol) {
            leaves.putIfAbsent(punctuationMarkSymbol, new PunctuationMark(punctuationMarkSymbol));
            return (PunctuationMark) leaves.get(punctuationMarkSymbol);
     }
}
