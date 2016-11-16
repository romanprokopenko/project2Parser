package ua.training.model.entity.head;

import ua.training.model.entity.Equipment;
import ua.training.model.entity.Material;

/**
 * Created by Graffit on 16.11.2016.
 */
public class Head extends Equipment {

    private HeadType headType;

    public Head(double price, double weight, Material material, HeadType headType) {
        super(price, weight, material);
        this.headType = headType;
    }

    public HeadType getHeadType() {
        return headType;
    }

    public void setHeadType(HeadType headType) {
        this.headType = headType;
    }
}
