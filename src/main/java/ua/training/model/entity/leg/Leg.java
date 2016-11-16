package ua.training.model.entity.leg;

import ua.training.model.entity.Equipment;
import ua.training.model.entity.Material;

/**
 * Created by Graffit on 16.11.2016.
 */
public class Leg extends Equipment {
    private LegType legType;

    public Leg(double price, double weight, Material material, LegType legType) {
        super(price, weight, material);
        this.legType = legType;
    }

    public LegType getLegType() {
        return legType;
    }

    public void setLegType(LegType legType) {
        this.legType = legType;
    }
}
