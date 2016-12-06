package ua.training.view;

/**
 * Interface of view
 *
 * @author Roman Prokopenko
 */
public interface View {

    /**
     * Outputs specified message
     *
     * @param message message
     */
    void printMessage(String message);

    void printNumberFormatted(Number message);
}
