package ua.training.model.entity.leaf.leafFactory;

import ua.training.model.entity.leaf.PunctuationMark;
import ua.training.model.entity.leaf.Word;

/**
 * Flyweight interface
 *
 * @author Roman Prokopenko
 */
public interface LeafFactory {

    /**
     * Checks if there is the same Word in Map.
     * Adds new word to Map if no. Then returns this Word
     *
     * @param wordText text of word
     * @return reference to Word object
     */
    Word createWord(String wordText);

    /**
     * Checks if there is the same PunctuationMark in Map.
     * Adds new word to Map if no. Then returns this PunctuationMark
     *
     * @param punctuationMarkSymbol text of punctuation mark
     * @return reference to PunctuationMark object
     */
    PunctuationMark createPunctuationMark(String punctuationMarkSymbol);
}
