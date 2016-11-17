package ua.training.model.entity.knight;

import ua.training.model.entity.equipment.Equipment;

import java.util.Comparator;

/**
 * Comparator of equipment's weight
 *
 * @author Roman Prokopenko
 */
public class EquipmentWeightComparator implements Comparator<Equipment> {
    @Override
    public int compare(Equipment o1, Equipment o2) {
        double firstItemWeight = o1.getWeight();
        double secondItemWeight = o2.getWeight();

        if (firstItemWeight > secondItemWeight) {
            return 1;
        } else if (firstItemWeight < secondItemWeight) {
            return -1;
        } else {
            return 0;
        }
    }
}
