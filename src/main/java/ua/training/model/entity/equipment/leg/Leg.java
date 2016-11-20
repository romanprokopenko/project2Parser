package ua.training.model.entity.equipment.leg;

import ua.training.model.entity.equipment.Equipment;
import ua.training.model.entity.equipment.Material;

/**
 * Class describes equipment for legs
 *
 * @author Roman Prokopenko
 */
public class Leg extends Equipment {

    /**
     * Leg equipment types
     */
    private LegType legType;

    /**
     * Shows if there are boots under the leg item
     */
    private boolean areBootsEquipped;

    /**
     * Constructor with parameters
     *
     * @param price price of item
     * @param weight weight of item
     * @param material item's material
     * @param legType leg item type
     * @param areBootsEquipped shows if boots are also equipped
     */
    public Leg(double price, double weight, Material material, LegType legType, boolean areBootsEquipped) {
        super(price, weight, material);
        this.legType = legType;
        this.areBootsEquipped = areBootsEquipped;
    }

    public LegType getLegType() {
        return legType;
    }

    public void setLegType(LegType legType) {
        this.legType = legType;
    }

    public boolean isAreBootsEquipped() {
        return areBootsEquipped;
    }

    public void setAreBootsEquipped(boolean areBootsEquipped) {
        this.areBootsEquipped = areBootsEquipped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leg)) return false;
        if (!super.equals(o)) return false;

        Leg leg = (Leg) o;

        if (areBootsEquipped != leg.areBootsEquipped) return false;
        return legType == leg.legType;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + legType.hashCode();
        result = 31 * result + (areBootsEquipped ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "legType=" + legType +
                ", areBootsEquipped=" + areBootsEquipped +
                ", price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                ", material=" + super.getMaterial() +
                '}';
    }
}
