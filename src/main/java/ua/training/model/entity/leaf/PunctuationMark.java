package ua.training.model.entity.leaf;

import ua.training.model.entity.ElementOfText;

/**
 * Created by Graffit on 06.12.2016.
 */
public class PunctuationMark implements ElementOfText {
    private String punctuationSymbol;

    public PunctuationMark() {}

    public PunctuationMark(String punctuationSymbol) {
        parse(punctuationSymbol);
    }

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
