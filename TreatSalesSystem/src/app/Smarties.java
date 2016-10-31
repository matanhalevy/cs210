package app;

public class Smarties extends Topper {

    private int price;
    //EFFECTS:  constructs a Smarties topper if it is onTopOf a Treat.
    //          ensures special treatment of this case in the super constructor.
    public Smarties(Treat onTopOf) {
        super(onTopOf);
        asString="smarties";
        price = 4;
    }

    //EFFECTS:  constructs a Smarties topper if it is onTopOf another topper.
    //          ensures special treatment of this case in the super constructor.
    public Smarties(Topper onTopOf) {
        super(onTopOf);
        asString="smarties";
        price = 3;
    }

    @Override
    public int itemCost(){
        return price;
    }

}
