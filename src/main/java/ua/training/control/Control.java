package ua.training.control;

import ua.training.control.init.InitEquipment;
import ua.training.model.Model;
import ua.training.model.entity.equipment.Material;
import ua.training.model.entity.equipment.arm.Arm;
import ua.training.model.entity.equipment.head.Head;
import ua.training.model.entity.equipment.head.HeadType;
import ua.training.model.entity.knight.Knight;
import ua.training.model.entity.equipment.leg.Leg;
import ua.training.model.entity.equipment.torso.Torso;
import ua.training.view.View;


/**
 * Class which controls the process of program work
 *
 * @author Roman Prokopenko
 */
public class Control {

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
    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {

        /*Knight instance initialization*/
        Knight knight = new Knight();
        knight.equipHead((Head) InitEquipment.HEAD.getEquipment());
        knight.equipTorso((Torso) InitEquipment.TORSO.getEquipment());
        knight.equipArm((Arm) InitEquipment.ARM.getEquipment());
        knight.equipLeg((Leg) InitEquipment.LEG.getEquipment());

        view.printMessage(View.UNSORTED_MESSAGE);
        view.printMessage(knight.toString());

        view.printMessage(View.SORTED_MESSAGE);
        knight.sortEquipmentByWeight();
        view.printMessage(knight.toString());

        view.printMessage(View.PRICE_MESSAGE);
        view.printNumberFormatted(knight.getEquipmentPrice());

        view.printMessage(View.FIND_MESSAGE);
        view.printMessage(knight.findEquipment(20, 100).toString());
    }
}

