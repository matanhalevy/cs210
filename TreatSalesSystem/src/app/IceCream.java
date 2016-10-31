package app;

public class IceCream extends Dippable {

    //MODIFIES: this: sets onTopOf=cone; sets the correct asString and correct connectingPhrase.
    //EFFECTS:  constructs an ice cream that sits onTopOf cone with correct strings and kind.
    //          uses the super() constructor to initialise onTopOf.
    public IceCream(String kind, Cone cone){
        super(cone);
        this.asString=kind+" ice cream";
        this.connectingPhrase = " on ";
    }

    @Override
    public int itemCost(){return 7;};

}
