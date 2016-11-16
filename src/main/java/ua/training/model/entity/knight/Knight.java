package ua.training.model.entity.knight;

import ua.training.model.entity.Equipment;
import ua.training.model.entity.head.Head;
import ua.training.model.entity.leg.Leg;
import ua.training.model.entity.torso.Torso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Graffit on 16.11.2016.
 */
public class Knight {
    private List<Equipment> equippedItems;

    public Knight() {
        equippedItems = new ArrayList<>();
    }

    public double getEquipmentPrice() {
        double sum = 0;
        for (Equipment e:
             equippedItems) {
            sum += e.getPrice();
        }
        return sum;
    }

    public List<Equipment> getSortedEquipmentList() {
        equippedItems.sort(new EquipmentWeightComparator());
        return equippedItems;
    }

    public void equipHead(Head head){
        putEquipment(head);
    }

    public Head unequipHead(){
        return (Head) unequip(Head.class);
    }

    public void equipTorso(Torso torso) {
        putEquipment(torso);
    }

    public Torso unequipTorso() {
        return (Torso) unequip(Torso.class);
    }

    public void equipLeg(Leg leg){
        putEquipment(leg);
    }

    private void putEquipment(Equipment item) {
        for (int i = 0; i < equippedItems.size(); i++) {
            if (equippedItems.get(i).getClass().isInstance(item)) {
                equippedItems.set(i, item);
                return;
            }
        }
        equippedItems.add(item);
    }

    private Equipment unequip(Class clazz) {
        for (int i = 0; i < equippedItems.size(); i++) {
            if (equippedItems.get(i).getClass().isAssignableFrom(clazz)) {
                Equipment result = equippedItems.get(i);
                equippedItems.remove(i);
                return result;
            }
        }
        throw new NullPointerException("no " + clazz.getName() + " equipped");
    }

}
