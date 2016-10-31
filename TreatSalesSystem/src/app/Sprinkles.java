package app;

public class Sprinkles extends Topper {
    private int price;

    //EFFECTS:  constructs a Smarties topper if it is onTopOf a Treat.
    //          ensures special treatment of this case in the super constructor.
    public Sprinkles(Treat onTopOf){
        super(onTopOf);
        asString = "sprinkles";
        price = 2;
    }

    //EFFECTS:  constructs a Smarties topper if it is onTopOf another topper.
    //          ensures special treatment of this case in the super constructor.
    public Sprinkles(Topper onTopOf){
        super(onTopOf);
        asString = "sprinkles";
        price = 1;
    }

    @Override
    public int itemCost(){return price;}
}
