package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a neighbourhood having a name in a city
 */
public class Neighbourhood implements GeoArea {
    private String neighborhoodName;
    private City city;
    private ArrayList<String> geoStrings;
    private String geoString;


    /**
     * Two neighbourhoods are equal if they have the same city and same name
     * When o is a City, this neighbourhood is equal to it, i
     * f it has the same city.
     */

    public Neighbourhood(String neighborhoodName, City city){
        this.neighborhoodName = neighborhoodName;
        this.city = city;
        geoString = null;
    }


    public City getCity() {
        return city;
    }

    public String getCityString() {
        return city.getCityString();

    }

    public ArrayList<String> getAllGeoStrings() {
        geoStrings = new ArrayList<String>();
        String[] parts = neighborhoodName.split("\\s+");
        for (int i = 0; i < parts.length; i++){
            String part = "";
            for (int k = 0; k < i + 1; k++){
                part = part + " " + parts[k];
            }
            geoStrings.add(part.trim() + ", " + city.getCityString());
        }
        return geoStrings;
    }


        @Override
        public boolean equals (Object o){
            if (this == o) return true;

            // will have to revisit this if we add subtypes of GeoArea other than City and Neighborhood
            if (o == null || !(o instanceof GeoArea)) return false;

            // when o is a City, this Neighborhood is equal to o if the cities are equal
            if (o instanceof City)
                return city.equals(o);

            // must be a Neighborhood
            Neighbourhood other = (Neighbourhood) o;

            return (city.equals(other.city));
        }

        @Override
        public int hashCode () {
            return city != null ? city.hashCode() : 0;
        }
    }


