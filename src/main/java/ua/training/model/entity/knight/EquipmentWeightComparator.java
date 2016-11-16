package ua.training.model.entity.knight;

import ua.training.model.entity.Equipment;

import java.util.Comparator;

/**
 * Created by Graffit on 16.11.2016.
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
