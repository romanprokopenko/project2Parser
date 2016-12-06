package ua.training.model.entity;

/**
 * Created by Graffit on 06.12.2016.
 */
public interface RegularExpression {
    String TEXT_REGEXP = "[-A-Za-zа-яА-ЯёЁ0-9,;()\\\"\\s]+[.?!]";
    String SENTENCE_REGEXP = "(?<" + SentenceElementType.WORD + ">[A-Za-zа-яА-ЯёЁ0-9]+)|" +
            "(?<" + SentenceElementType.PUNCTUATION_MARK + ">[-\\s,;()-\\.?!\\\"]{1,1})";
}