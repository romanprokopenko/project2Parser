package ua.training.view;

/**
 * Class which used to interact with player
 *
 * @author Roman Prokopenko
 */
public class ParserView implements View {

    /**
     * Prints message to System.out
     *
     * @param message any string
     */
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
