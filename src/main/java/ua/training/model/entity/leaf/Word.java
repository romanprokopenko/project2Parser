package ua.training.model.entity.leaf;

import ua.training.model.entity.ElementOfText;

/**
 * Represents word from which sentence consists of.
 * Implements ElementOfText and is a leaf of composite.
 *
 * @author Roman Prokopenko
 */
public class Word implements ElementOfText {
    /**
     * String that contain word
     */
    private String wordSymbols;

    /**
     * Default constructor
     */
    public Word() {}

    /**
     * Constructor with parameters. Calls parse method
     *
     * @param wordSymbols word
     */
    public Word(String wordSymbols) {
        parse(wordSymbols);
    }

    /**
     * As this is leaf element, parse sets parameter of this method as
     * this object's content
     *
     * @param wordSymbols word
     */
    @Override
    public void parse(String wordSymbols) {
        this.wordSymbols = wordSymbols;
    }

    @Override
    public String toString() {
        return wordSymbols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        return wordSymbols.equals(word.wordSymbols);

    }

    @Override
    public int hashCode() {
        return wordSymbols.hashCode();
    }
}
