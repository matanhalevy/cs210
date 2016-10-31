package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a route having a list of legs and a distance.
 */
public class Route {
    private ArrayList<Leg> route;
    private int distance;
    public  Route(){
       this.route = new ArrayList<Leg>();
        distance = 0;

    }
    // how do I add a list to a list?
    public void addLeg(Leg leg){
        route.add(leg);
        distance = leg.getDistance() + distance;

    }

    public int getDistance(){
        return distance;
    }

    public List<Leg> getLegs(){
        return route;
    }
}
