package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a leg that has an arbitrary number of points and a distance.  Part of a route.
 */
public class Leg {
    public int distance;

    private List<LatLng> Leg;

    public Leg(){
       this.Leg = new ArrayList<LatLng>();
        distance = 0;
    }
    // shit man idk how to do this
    // i would do a for loop that adds the first point by calling addPoint, then iterate through the list until
    // there are no more points in the list. Right? RIGHT?!?!?!?!

    public void addAllPoints(List<LatLng> pts){
        Leg.addAll(pts);
        }


    // this is where I add one point to the list of poitns
    public void addPoint(LatLng pt){
        Leg.add(pt);
    }

    public List<LatLng> getPoints(){
        return this.Leg;
    }
    public int getDistance(){
        return distance;
    }

    public void setDistance(int d){
        this.distance = d;
    }
}


