package ua.training.model.entity.leaf;

import ua.training.model.entity.ElementOfText;

/**
 * Created by Graffit on 06.12.2016.
 */
public class Word implements ElementOfText {
    private String wordSymbols;

    public Word() {}

    public Word(String wordSymbols) {
        parse(wordSymbols);
    }

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
