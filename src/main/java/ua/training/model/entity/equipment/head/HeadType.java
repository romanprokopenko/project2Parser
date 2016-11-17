package ua.training.model.entity.equipment.head;

/**
 * Types of head equipment
 *
 * @author Roman Prokopenko
 */
public enum HeadType {
    KETTLE(false), SALLET(false), GREAT(false), CLOSE(true), ARMET(true);

    private boolean hasVisor;

    HeadType(boolean hasVisor) {
        this.hasVisor = hasVisor;
    }

    public boolean hasVisor() {
        return hasVisor;
    }
}
