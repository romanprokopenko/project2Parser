package ua.training;

import ua.training.control.Control;
import ua.training.control.ParserControl;
import ua.training.model.Model;
import ua.training.model.ParserModel;
import ua.training.view.ParserView;
import ua.training.view.View;

/**
 * Class represents main class where the program starts
 *
 * @author Roman Prokopenko
 */
public class Main {
    public static void main(String[] args) {

        //initialization of components
        View view = new ParserView();
        Model model = new ParserModel();
        Control control = new ParserControl(model, view);

        //run
        control.processUser();
    }
}
