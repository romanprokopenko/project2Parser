package ua.training.model.entity.leaf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Graffit on 06.12.2016.
 */
public abstract class LeafFactory {
    private static Map<String, Word> words = new HashMap<>();
    private static Map<String, PunctuationMark> punctuationMarks = new HashMap<>();

    public static Word createWord(String wordText) {
        words.putIfAbsent(wordText, new Word(wordText));
        return words.get(wordText);
    }

    public static PunctuationMark createPunctuationMark(String punctuationMarkSymbol) {
        punctuationMarks.putIfAbsent(punctuationMarkSymbol, new PunctuationMark(punctuationMarkSymbol));
        return punctuationMarks.get(punctuationMarkSymbol);
    }
}
