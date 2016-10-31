package app;

public abstract class Treat implements Chargeable{
    Treat   onTopOf;
    String  asString;
    String  connectingPhrase;

    public Treat(){};

    //EFFECTS:  basic constructor for a Treat onTopOf a Treat.
    public Treat(Treat onTopOf){
        this.onTopOf = onTopOf;
    }

    //MODIFIES: nothing.
    //EFFECTS:  returns the toString of this object, plus reads out the order of object it is onTopOf.
    public String readOutOrder(){
        return this.toString() + onTopOf.readOutOrder();
    }


    //EFFECTS:  returns this object's asString representation, plus its connecting phrase
    public String toString(){
        return asString + connectingPhrase;
    }

    public int calculateCost(){
        if (this.onTopOf != null){
            return this.itemCost() + onTopOf.calculateCost();
        }
        return this.itemCost();
    }

}
