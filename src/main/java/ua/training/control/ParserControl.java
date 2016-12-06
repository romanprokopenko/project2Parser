package ua.training.control;

import ua.training.model.Model;
import ua.training.model.ParserModel;
import ua.training.model.entity.composite.Text;
import ua.training.view.ParserView;
import ua.training.view.View;

import java.io.IOException;


/**
 * Class which controls the process of program work
 *
 * @author Roman Prokopenko
 */
public class ParserControl implements Control {
    private static final String FILE_PATH = "test.txt";
    /**
     * Reference to model part
     *
     * @see ParserModel
     */
    private Model model;

    /**
     * Reference to view part
     *
     * @see ParserView
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
        try {
            view.printMessage(model.processText(model.getText(FILE_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

