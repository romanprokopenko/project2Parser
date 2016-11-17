package ua.training.view;

/**
 * Class which used to interact with player
 *
 * @author Roman Prokopenko
 */
public class View {

    public static final String UNSORTED_MESSAGE = "unsorted list of equipment:";
    public static final String SORTED_MESSAGE = "sorted by weight list of equipment:";
    public static final String PRICE_MESSAGE = "total price of equipment:";
    public static final String FIND_MESSAGE = "list of equipment of specified price:";

    /**
     * Prints message to System.out
     *
     * @param message any string
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printNumberFormatted(Number message) {
        System.out.println(String.format("%1.2f", message));
    }
}
