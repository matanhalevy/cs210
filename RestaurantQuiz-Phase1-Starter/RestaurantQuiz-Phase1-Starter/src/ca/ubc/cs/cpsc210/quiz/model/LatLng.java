package ca.ubc.cs.cpsc210.quiz.model;

/**
 * Stand-in for com.google.android.gms.maps.model.LatLng
 * Represents a position specified with latitude/longitude coords
 */
public class LatLng {
    private double lat;
    private double lng;

    public LatLng(double lat, double lng){
        this.lat = lat;
        this.lng = lng;

    }

    public double getLat(){
        return this.lat;
    }

    public double getLng(){
        return this.lng;
    }

}


