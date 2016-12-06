package ua.training.model.entity.leaf;

import ua.training.model.entity.ElementOfText;

/**
 * Represents punctuation marks from which sentence consists of.
 * Implements ElementOfText and is a leaf of composite.
 *
 * @author Roman Prokopenko
 */
public class PunctuationMark implements ElementOfText {

    /**
     * String that contains punctuation mark
     */
    private String punctuationSymbol;

    /**
     * Default constructor
     */
    public PunctuationMark() {}

    /**
     * Constructor with parameters. Calls parse method
     *
     * @param punctuationSymbol punctuation mark
     */
    public PunctuationMark(String punctuationSymbol) {
        parse(punctuationSymbol);
    }

    /**
     * As this is leaf element, parse sets parameter of this method as
     * this object's content
     *
     * @param punctuationSymbol punctuation mark
     */
    @Override
    public void parse(String punctuationSymbol) {
        this.punctuationSymbol = punctuationSymbol;
    }

    @Override
    public String toString() {
        return punctuationSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PunctuationMark)) return false;

        PunctuationMark that = (PunctuationMark) o;

        return punctuationSymbol.equals(that.punctuationSymbol);

    }

    @Override
    public int hashCode() {
        return punctuationSymbol.hashCode();
    }
}
