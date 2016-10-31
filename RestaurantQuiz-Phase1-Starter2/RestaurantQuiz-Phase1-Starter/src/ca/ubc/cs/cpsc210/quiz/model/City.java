package ca.ubc.cs.cpsc210.quiz.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a name having a name, province/state code and country code
 */
public class City implements GeoArea {
    private String name;
    private String prov;
    private String countryCode;
    private ArrayList<String> geoStrings;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof GeoArea)) return false;
        if (o instanceof Neighbourhood)
            return o.equals(this);

        City city = (City) o;

        if (!countryCode.equals(city.countryCode)) return false;
        if (!geoStrings.equals(city.geoStrings)) return false;
        if (!name.equals(city.name)) return false;
        if (!prov.equals(city.prov)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + prov.hashCode();
        result = 31 * result + countryCode.hashCode();
        result = 31 * result + geoStrings.hashCode();
        return result;
    }

    public City (String name, String prov, String countryCode) throws IllegalArgumentException{
        this.name= name;
        if (prov.length() != 2){
            throw new IllegalArgumentException();
        }
        this.prov= prov;
        if (countryCode.length()!= 2){
            throw new IllegalArgumentException();
        }
        this.countryCode= countryCode;
        List<String> geoStrings = new ArrayList<String>();

    }
    public String getCityString(){
        return (name + ", "+ prov + ", " + countryCode);
    }

    public ArrayList<String> getAllGeoStrings(){
        geoStrings = new ArrayList<String>();
        geoStrings.add(name + ", "+ prov + ", " + countryCode);
        return geoStrings;
    }
}
