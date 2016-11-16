package ua.training.model.entity;

/**
 * Created by Graffit on 16.11.2016.
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
    public String toString() {
        return "Equipment{" +
                "price=" + price +
                ", weight=" + weight +
                ", material=" + material +
                '}';
    }
}
