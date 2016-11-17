package ua.training.control.init;

import ua.training.model.entity.equipment.Equipment;
import ua.training.model.entity.equipment.Material;
import ua.training.model.entity.equipment.arm.Arm;
import ua.training.model.entity.equipment.arm.ArmType;
import ua.training.model.entity.equipment.head.Head;
import ua.training.model.entity.equipment.head.HeadType;
import ua.training.model.entity.equipment.leg.Leg;
import ua.training.model.entity.equipment.leg.LegType;
import ua.training.model.entity.equipment.torso.Torso;
import ua.training.model.entity.equipment.torso.TorsoType;

/**
 * Created by Graffit on 17.11.2016.
 */
public enum InitEquipment {
    HEAD(new Head(13.99, 10, Material.LEATHER, HeadType.SALLET)),
    TORSO(new Torso(58.00, 30, Material.IRON, TorsoType.CUIRASS)),
    ARM(new Arm(7.50, 8, Material.IRON, ArmType.GAUNTLET)),
    LEG(new Leg(20, 20.3, Material.STEEL, LegType.GREAVE, true));

    private Equipment equipment;

    InitEquipment(Equipment equipment){
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}
