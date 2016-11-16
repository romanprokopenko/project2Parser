package ua.training.control;

import ua.training.model.Model;
import ua.training.model.entity.Equipment;
import ua.training.model.entity.Material;
import ua.training.model.entity.head.Head;
import ua.training.model.entity.head.HeadType;
import ua.training.model.entity.knight.Knight;
import ua.training.model.entity.torso.Torso;
import ua.training.model.entity.torso.TorsoType;
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

    class newhead extends Head{
        public newhead(double price, double weight, Material material, HeadType headType) {
            super(price, weight, material, headType);
        }
    }

    public void processUser() {
        Equipment head1 = new Head(9.99, 10, Material.IRON, HeadType.GREAT);
        Head head2 = new Head(8.88, 10, Material.IRON, HeadType.GREAT);
        Torso torso1 = new Torso(1, 50, Material.LEATHER, TorsoType.BRIGANDINE);
        Knight knight = new Knight();
        knight.equipHead((Head) head1);
        knight.equipHead(head2);

        System.out.println(knight.unequipHead().getPrice());
        //knight.unequipHead();
        //knight.unequipTorso();
    }
}

