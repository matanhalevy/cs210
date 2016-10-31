package app;

/**
 * This interface must be implemented for Task 2.
 */
public interface Chargeable {
    //EFFECTS: returns the object's own cost, plus the cost of it's onTopOf object.
    public int calculateCost();

    //EFFECTS: returns the object's own cost.
    public int itemCost();
}
