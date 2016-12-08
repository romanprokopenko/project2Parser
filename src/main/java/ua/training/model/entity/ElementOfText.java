package ua.training.model.entity;

/**
 * Composite elements interface
 *
 * @author Roman Prokopenko
 */
public interface ElementOfText {

    /**
     * Method which assembles composite element from String parameter
     *
     * @param text data that is needed to assemble the element
     */
    void parse(String text);
}
