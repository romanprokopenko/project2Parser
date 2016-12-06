package ua.training.model.entity;

/**
 * Created by Graffit on 06.12.2016.
 */
public enum SentenceElementType {
    WORD("word"), PUNCTUATION_MARK("punctuationMark");

    private String type;

    SentenceElementType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
