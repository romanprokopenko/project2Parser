package ua.training.model.entity;

/**
 * Enum with types of groups of regex for sentence
 *
 * @author Roman Prokopenko
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
