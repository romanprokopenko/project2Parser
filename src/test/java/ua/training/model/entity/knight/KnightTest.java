package ua.training.model.entity.knight;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.control.init.InitEquipment;
import ua.training.model.entity.equipment.Equipment;
import ua.training.model.entity.equipment.arm.Arm;
import ua.training.model.entity.equipment.head.Head;
import ua.training.model.entity.equipment.leg.Leg;
import ua.training.model.entity.equipment.torso.Torso;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Roman Prokopenko on 17.11.2016.
 */
public class KnightTest {

    private Knight actualKnight;
    @Before
    public void initialize() {
        actualKnight = new Knight();
        actualKnight.equipHead((Head) InitEquipment.HEAD.getEquipment());
        actualKnight.equipTorso((Torso) InitEquipment.TORSO.getEquipment());
        actualKnight.equipArm((Arm) InitEquipment.ARM.getEquipment());
        actualKnight.equipLeg((Leg) InitEquipment.LEG.getEquipment());
    }

    @Test
    public void findEquipment() throws Exception {
        List<Equipment> expectedKnight = new ArrayList<>();
        expectedKnight.add(InitEquipment.TORSO.getEquipment());
        expectedKnight.add(InitEquipment.LEG.getEquipment());
        List<Equipment> actualList = actualKnight.findEquipment(20, 100);
        Assert.assertArrayEquals(expectedKnight.toArray(),actualList.toArray());
    }

    @Test
    public void sortEquipmentByWeight() throws Exception {
        actualKnight.sortEquipmentByWeight();
        List<Equipment> expectedList = new ArrayList<>();
        expectedList.add(InitEquipment.ARM.getEquipment());
        expectedList.add(InitEquipment.HEAD.getEquipment());
        expectedList.add(InitEquipment.LEG.getEquipment());
        expectedList.add(InitEquipment.TORSO.getEquipment());
        Assert.assertArrayEquals(actualKnight.getEquippedItems().toArray(),
                                    expectedList.toArray());
    }


    @Test
    public void getEquipmentPrice() throws Exception {
        double actualPrice = actualKnight.getEquipmentPrice();
        double expectedPrice = InitEquipment.HEAD.getEquipment().getPrice() +
                                InitEquipment.TORSO.getEquipment().getPrice() +
                                InitEquipment.ARM.getEquipment().getPrice() +
                                InitEquipment.LEG.getEquipment().getPrice();
        double delta = 1e-6;
        Assert.assertEquals(expectedPrice, actualPrice, delta);
    }

}