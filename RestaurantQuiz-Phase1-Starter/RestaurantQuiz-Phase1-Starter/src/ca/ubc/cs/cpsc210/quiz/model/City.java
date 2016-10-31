package ca.ubc.cs.cpsc210.quiz.model;

/**
 * Represents a name having a name, province/state code and country code
 */
public class City implements GeoArea {
    private String name;
    private String prov;
    private String countryCode;


    public City (String name, String prov, String countryCode){
        this.name= name;
        this.prov= prov;
        this.countryCode= countryCode;

    }
    public String getCityString(){
        return (name + ", "+ prov + ", " + countryCode);
    }
}
