package ua.training.model.entity.equipment.arm;

import ua.training.model.entity.equipment.Equipment;
import ua.training.model.entity.equipment.Material;

/**
 * Class describes equipment for arm
 *
 * @author Roman Prokopenko
 */
public class Arm extends Equipment {

    /**
     * Type of arm equipment
     */
    private ArmType armType;

    /**
     * Shows if knight can hold something in arms
     */
    private boolean itemInArm;

    public Arm(double price, double weight, Material material, ArmType armType) {
        super(price, weight, material);
        this.armType = armType;
    }

    public ArmType getArmType() {
        return armType;
    }

    public void setArmType(ArmType armType) {
        this.armType = armType;
    }

    public boolean getItemInArm() {
        return itemInArm;
    }

    public void setItemInArm(boolean itemInArm) {
        this.itemInArm = itemInArm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arm)) return false;
        if (!super.equals(o)) return false;

        Arm arm = (Arm) o;

        if (itemInArm != arm.itemInArm) return false;
        return armType == arm.armType;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + armType.hashCode();
        result = 31 * result + (itemInArm ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Arm{" +
                "armType=" + armType +
                ", itemInArm=" + (itemInArm ? "equipped" : "empty") +
                ", price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                ", material=" + super.getMaterial() +
                '}';
    }
}
