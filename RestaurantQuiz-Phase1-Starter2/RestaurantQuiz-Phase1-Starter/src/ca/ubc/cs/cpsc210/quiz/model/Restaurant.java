package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a restaurant having a street address, geographical area, postal code, name, id categories
 * and list of reviews.
 */

public class Restaurant {
    List<Category> categories;
    String address;
    String postalCode;
    String name;
    String id;
    GeoArea geographicalArea;
    public Restaurant (String address, String postalCode, String name, String id, GeoArea geographicalArea, ArrayList<Category> categories){
        this.categories = categories;
        this.address = address;
        this.name = name;
        this.id = id;
        this.geographicalArea=geographicalArea;
        this.postalCode = postalCode;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public GeoArea getGeographicalArea() {
        return geographicalArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;

        Restaurant that = (Restaurant) o;

        if (!address.equals(that.address)) return false;
        if (!categories.equals(that.categories)) return false;
        if (!geographicalArea.equals(that.geographicalArea)) return false;
        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!postalCode.equals(that.postalCode)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categories.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + postalCode.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + geographicalArea.hashCode();
        return result;
    }

    public String toString (){
    return (name + ", " + geographicalArea.getCityString() + ", " + postalCode);
    }
}