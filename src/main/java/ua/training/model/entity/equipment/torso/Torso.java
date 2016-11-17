package ua.training.model.entity.equipment.torso;

import ua.training.model.entity.equipment.Equipment;
import ua.training.model.entity.equipment.Material;

/**
 * Class describes equipment for torso
 *
 * @author Roman Prokopenko
 */
public class Torso extends Equipment {

    /**
     * Torso equipment types
     */
    private TorsoType torsoType;

    public Torso(double price, double weight, Material material, TorsoType torsoType) {
        super(price, weight, material);
        this.torsoType = torsoType;
    }

    public TorsoType getTorsoType() {
        return torsoType;
    }

    public void setTorsoType(TorsoType torsoType) {
        this.torsoType = torsoType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Torso)) return false;
        if (!super.equals(o)) return false;

        Torso torso = (Torso) o;

        return torsoType == torso.torsoType;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + torsoType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Torso{" +
                "torsoType=" + torsoType +
                ", price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                ", material=" + super.getMaterial() +
                '}';
    }
}
