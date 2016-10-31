package app;

public class Cone extends Dippable {

    public Cone() {
        super(null);
        asString="a cone";
        onTopOf=null;
    }

    //EFFECTS:  returns the string version of the class.
    //          This is the base case, since the cone has no "onTopOf".
    //          This overrides the Treat.readOutOrder method which gets called for other Treats.
    public String readOutOrder(){
        return asString;
    }

    @Override
    public int itemCost(){return 6;}
}
