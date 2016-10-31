package ca.ubc.cpsc210.spaceinvaders.ui;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Yoram on 2014-12-01.
 */
public class ConsoleWriter implements Observer {
    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("HIT BY A MISSILE!");
    }
}
