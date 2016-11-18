package ua.training.model.entity.knight;

import ua.training.model.entity.equipment.Equipment;
import ua.training.model.entity.equipment.arm.Arm;
import ua.training.model.entity.equipment.head.Head;
import ua.training.model.entity.equipment.leg.Leg;
import ua.training.model.entity.equipment.torso.Torso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class describes knight entity.
 * Contains collection of knight's equipment
 *
 * @author Roman Prokopenko
 */
public class Knight {
    private List<Equipment> equippedItems;

    public Knight() {
        equippedItems = new ArrayList<>();
    }

    /**
     * Calculates summary price of knight's equipment
     *
     * @return equipment price
     */
    public Double getEquipmentPrice() {
        double sum = 0;
        for (Equipment e :
                equippedItems) {
            sum += e.getPrice();
        }
        return sum;
    }

    /**
     * finds equipment which price corresponds to bounds
     *
     * @param minimumPrice lower bound
     * @param maximumPrice upper bound
     * @return List of equipment
     */
    public List<Equipment> findEquipment(double minimumPrice, double maximumPrice) {
        return equippedItems.stream()
                .filter((s) -> ((minimumPrice <= s.getPrice()) &&
                                (s.getPrice() <= maximumPrice)))
                .collect(Collectors.toList());
    }

    /**
     * Sorts equipment list using {@link EquipmentWeightComparator}
     */
    public void sortEquipmentByWeight() {
        equippedItems.sort(new EquipmentWeightComparator());
    }

    /*getters and setters*/
    public List<Equipment> getEquippedItems() {
        return equippedItems;
    }

    public void equipHead(Head head) {
        putEquipment(head);
    }

    public Head unequipHead() {
        return (Head) unequip(Head.class);
    }

    public void equipTorso(Torso torso) {
        putEquipment(torso);
    }

    public Torso unequipTorso() {
        return (Torso) unequip(Torso.class);
    }

    public void equipArm(Arm arm) {
        putEquipment(arm);
    }

    public Arm unequipArm() {
        return (Arm) unequip(Arm.class);
    }

    public void equipLeg(Leg leg) {
        putEquipment(leg);
    }

    public Leg uneqipLeg() {
        return (Leg) unequip(Leg.class);
    }

    /**
     * Adds new equipment item to equipment collection. Because there can be only
     * one instance of each type in collection, method checks collection. If collection
     * already contains item of same type, replaces it with new item
     *
     * @param item item to put in collection
     */
    private void putEquipment(Equipment item) {
        for (int i = 0; i < equippedItems.size(); i++) {
            if (equippedItems.get(i).getClass().isInstance(item)
                    || item.getClass().isInstance(equippedItems.get(i))) {
                equippedItems.set(i, item);
                return;
            }
        }
        equippedItems.add(item);
    }

    /**
     * Removes and returns item of defined type from equipment collection.
     * If there is no suitable item in collection throws {@link NoSuchItemTypeException}
     *
     * @param equipmentClass type of item to remove. Must extend Equipment
     * @return removed item
     */
    private Equipment unequip(Class<? extends Equipment> equipmentClass) {
        for (int i = 0; i < equippedItems.size(); i++) {
            if (equipmentClass.isAssignableFrom(equippedItems.get(i).getClass())) {
                Equipment result = equippedItems.get(i);
                equippedItems.remove(i);
                return result;
            }
        }
        String exceptionMessage = equipmentClass.getName() + " not equipped";
        throw new NoSuchItemTypeException(exceptionMessage);
    }

    @Override
    public String toString() {
        return "Knight{" +
                "equippedItems=" + equippedItems +
                '}';
    }
}
