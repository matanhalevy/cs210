package app;

/**
 * Created by Yoram on 2014-11-30.
 */
public abstract class Dippable extends Treat {
    public Dippable(Dippable onTopOf) {
        super(onTopOf);
    }
}
