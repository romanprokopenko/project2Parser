package ua.training.model.entity.equipment.head;

import ua.training.model.entity.equipment.Equipment;
import ua.training.model.entity.equipment.Material;

/**
 * Class describes equipment for head
 *
 * @author Roman Prokopenko
 */
public class Head extends Equipment {

    /**
     * Type of head equipment
     */
    private HeadType headType;

    /**
     * Shows if headType permit existence of visor
     */
    private boolean hasVisor;

    public Head(double price, double weight, Material material, HeadType headType) {
        super(price, weight, material);
        this.headType = headType;
        this.hasVisor = headType.hasVisor();
    }

    public HeadType getHeadType() {
        return headType;
    }

    public void setHeadType(HeadType headType) {
        this.headType = headType;
        this.hasVisor = headType.hasVisor();
    }

    public boolean hasVisor() {
        return hasVisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Head)) return false;
        if (!super.equals(o)) return false;

        Head head = (Head) o;

        if (hasVisor != head.hasVisor) return false;
        return headType == head.headType;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + headType.hashCode();
        result = 31 * result + (hasVisor ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Head{" +
                "headType=" + headType +
                ", hasVisor=" + hasVisor +
                ", price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                ", material=" + super.getMaterial() +
                '}';
    }
}
