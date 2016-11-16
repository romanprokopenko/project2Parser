package ua.training.model.entity.torso;

import ua.training.model.entity.Equipment;
import ua.training.model.entity.Material;

/**
 * Created by Graffit on 16.11.2016.
 */
public class Torso extends Equipment {
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
}
