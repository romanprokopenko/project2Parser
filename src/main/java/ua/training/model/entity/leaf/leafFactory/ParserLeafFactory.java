package ua.training.model.entity.leaf.leafFactory;

import ua.training.model.entity.ElementOfText;
import ua.training.model.entity.leaf.PunctuationMark;
import ua.training.model.entity.leaf.Word;

import java.util.HashMap;
import java.util.Map;

/**
 * Class which controls creation of leaf elements
 *
 * @author Roman Prokopenko
 */
public class ParserLeafFactory implements LeafFactory {

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
    @Override
    public Word createWord(String wordText) {
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
     @Override
     public PunctuationMark createPunctuationMark(String punctuationMarkSymbol) {
            leaves.putIfAbsent(punctuationMarkSymbol, new PunctuationMark(punctuationMarkSymbol));
            return (PunctuationMark) leaves.get(punctuationMarkSymbol);
     }
}
