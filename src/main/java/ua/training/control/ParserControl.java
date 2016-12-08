package ua.training.control;

import ua.training.model.Model;
import ua.training.view.View;

import java.io.IOException;


/**
 * Class which controls the process of program work
 *
 * @author Roman Prokopenko
 */
public class ParserControl implements Control {
    /**
     * Path to txt file from which text is read
     */
    private static final String FILE_PATH = "input.txt";
    /**
     * Reference to model part
     *
     * @see Model
     */
    private Model model;

    /**
     * Reference to view part
     *
     * @see View
     */
    private View view;

    /**
     * Constructor which binds model and view with controller
     *
     * @param model reference to model
     * @param view  reference to view
     */
    public ParserControl(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void processUser() {
        System.out.println(View.START_MESSAGE + FILE_PATH);
        try {
            String data = model.getText(FILE_PATH);
            view.printMessage(View.END_MESSAGE);
            view.printMessage(model.processText(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

