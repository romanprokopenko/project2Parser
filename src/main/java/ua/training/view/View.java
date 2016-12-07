package ua.training.view;

/**
 * Interface of view
 *
 * @author Roman Prokopenko
 */
public interface View {

    String START_MESSAGE = "text is read from file:";
    String END_MESSAGE = "processed text:";

    /**
     * Outputs specified message
     *
     * @param message message
     */
    void printMessage(String message);
}
