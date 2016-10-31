package app;

/**
 * Created by Yoram on 2014-11-30.
 */
public class ChocolateDip extends Dippable {
    public ChocolateDip(Dippable onTopOf) {
        super(onTopOf);
        this.asString = "chocolate dip";
        this.connectingPhrase = " over ";
    }

    @Override
    public int itemCost(){return 5;}
}
