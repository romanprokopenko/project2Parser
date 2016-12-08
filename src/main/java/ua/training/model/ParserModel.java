package ua.training.model;


import ua.training.model.entity.ElementOfText;
import ua.training.model.entity.RegularExpression;
import ua.training.model.entity.composite.AbstractCompositeElementOfText;
import ua.training.model.entity.composite.Sentence;
import ua.training.model.entity.composite.Text;
import ua.training.model.entity.leaf.Word;
import ua.training.model.textreader.ParserTextReader;
import ua.training.model.textreader.TextReader;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation of {@link Model}
 *
 * @author Roman Prokopenko
 */
public class ParserModel implements Model {

    /**
     * Reader of text from file
     */
    private TextReader reader = new ParserTextReader();

    /**
     * Text composite
     */
    private AbstractCompositeElementOfText text = new Text();

    @Override
    public String getText(String filePath) throws IOException {
        return reader.getTextFromFile(filePath);
    }

    @Override
    public String processText(String inputText) {
        this.text.parse(inputText);
        for (ElementOfText element :
                this.text.getSubElements()) {
            removeCode((Sentence) element);
            swapFirstLastWord((Sentence) element);
        }
        return this.text.toString();
    }

    /**
     * Removes code from specified sentence
     *
     * @param sentence Sentence
     */
    void removeCode(Sentence sentence) {
        String stopString = "\n";
        for (int i = 0; i < sentence.getSubElements().size(); i++) {
            if (sentence.getSubElements().get(i).toString().matches(RegularExpression.CODE_START_REGEXP)) {
                removeElementsToEndLine(sentence.getSubElements(), i, stopString);
            }
        }
    }

    /**
     * Removes all elements from specified list from specified position
     * until stopString appears
     *
     * @param list       list
     * @param index      start index
     * @param stopString stop string
     */
    void removeElementsToEndLine(List<ElementOfText> list, int index, String stopString) {
        ListIterator<ElementOfText> listIterator = list.listIterator(index);
        while (listIterator.hasNext()) {
            if (listIterator.next().toString().equals(stopString)) {
                break;
            } else {
                listIterator.remove();
            }
        }
    }

    /**
     * Swap first and last words in a specified sentence
     *
     * @param sentence sentence
     */
    private void swapFirstLastWord(Sentence sentence) {
        int firstIndex = findFirstWordIndex(sentence.getSubElements());
        int lastIndex = findLastWordIndex(sentence.getSubElements());
        swapListElements(sentence.getSubElements(), firstIndex, lastIndex);
    }

    /**
     * Swaps two elements of list
     *
     * @param list        list
     * @param firstIndex  index of first element
     * @param secondIndex index of second element
     */
    void swapListElements(List list, int firstIndex, int secondIndex) {
        Object tmp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, tmp);
    }

    /**
     * Search for index of first appearance of {@link Word} element
     * in list of sub elements
     *
     * @param list list of sub elements
     * @return index
     */
    int findFirstWordIndex(List<ElementOfText> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Word) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Search for index of last appearance of {@link Word} element
     * in list of sub elements
     *
     * @param list list of sub elements
     * @return index
     */
    int findLastWordIndex(List<ElementOfText> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) instanceof Word) {
                return i;
            }
        }
        return -1;
    }
}

