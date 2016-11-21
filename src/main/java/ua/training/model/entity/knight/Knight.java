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
    /**
     * Collection of knight's equipment
     */
    private List<Equipment> equippedItems;

    /**
     * Default constructor. Initialize list of equipment with empty
     * ArrayList
     */
    public Knight() {
        equippedItems = new ArrayList<>();
    }

    /**
     * Calculates summary price of knight's equipment
     *
     * @return equipment price
     */
    public Double getEquipmentPrice() {
        return equippedItems.stream().mapToDouble(Equipment::getPrice).sum();
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
     * Sorts equipment list by weight
     */
    public void sortEquipmentByWeight() {
        equippedItems.sort((Equipment o1, Equipment o2) -> {
            if (o1.getWeight() > o2.getWeight()) {
                return 1;
            } else if (o1.getWeight() < o2.getWeight()) {
                return -1;
            } else {
                return 0;
            }
        });
    }

    /*getters and setters*/
    public List<Equipment> getEquippedItems() {
        return equippedItems;
    }

    /**
     * Add new Head item to equipment
     *
     * @param head head equipment
     */
    public void equipHead(Head head) {
        putEquipment(head);
    }

    /**
     * Removes existing head item from collection
     *
     * @return removed item
     */
    public Head unequipHead() {
        return (Head) unequip(Head.class);
    }

    /**
     * Add new Torso item to equipment
     *
     * @param torso torso equipment
     */
    public void equipTorso(Torso torso) {
        putEquipment(torso);
    }

    /**
     * Removes existing torso item from collection
     *
     * @return removed item
     */
    public Torso unequipTorso() {
        return (Torso) unequip(Torso.class);
    }

    /**
     * Add new Arm item to equipment
     *
     * @param arm arm equipment
     */
    public void equipArm(Arm arm) {
        putEquipment(arm);
    }

    /**
     * Removes existing arm item from collection
     *
     * @return removed item
     */
    public Arm unequipArm() {
        return (Arm) unequip(Arm.class);
    }

    /**
     * Add new Leg item to equipment
     *
     * @param leg leg equipment
     */
    public void equipLeg(Leg leg) {
        putEquipment(leg);
    }

    /**
     * Removes existing leg item from collection
     *
     * @return removed item
     */
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
                return equippedItems.remove(i);
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
