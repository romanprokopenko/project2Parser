package ua.training.model.entity.equipment;

/**
 * Class describes abstract knight's equipment.
 * Has price, weight and material.
 *
 * @author Roman Prokopenko
 */
public abstract class Equipment {

    /**
     * equipment price
     */
    private double price;

    /**
     * equipment weight
     */
    private double weight;

    /**
     * material of equipment
     */
    private Material material;

    public Equipment(double price, double weight, Material material) {
        this.price = price;
        this.weight = weight;
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;

        Equipment equipment = (Equipment) o;

        if (Double.compare(equipment.price, price) != 0) return false;
        if (Double.compare(equipment.weight, weight) != 0) return false;
        return material == equipment.material;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + material.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "price=" + price +
                ", weight=" + weight +
                ", material=" + material +
                '}';
    }
}
