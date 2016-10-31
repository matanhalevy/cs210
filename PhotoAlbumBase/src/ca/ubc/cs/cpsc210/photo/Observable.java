package ca.ubc.cs.cpsc210.photo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Yoram on 2014-12-02.
 */
public class Observable {
    public List<Observer> observers;

    public Observable(){
        observers = new ArrayList<Observer>();
    }

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void notifyObservers(String s){
        for (Observer o : observers){
            o.update(s);
        }
    }
}
