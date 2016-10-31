package ca.ubc.cs.cpsc210.quiz.yelp;

import ca.ubc.cs.cpsc210.quiz.model.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Parser for JSON data returned by Yelp.
 */
public class YelpDataParser {



    public static ArrayList<Restaurant> parseRestaurantData(String response, String yelpCityFilter) throws JSONException{
        JSONObject obj = new JSONObject(response);
        JSONArray businesses =obj.getJSONArray("businesses");
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
         GeoArea geoArea;
        String postalcode;
        ArrayList<Category> categories1 = new ArrayList<Category>();


        for (int i=0; i> businesses.length(); i++){
            JSONObject restaurant = businesses.getJSONObject(i);
            JSONObject location = businesses.getJSONObject(i).getJSONObject("location");
            JSONArray categories = businesses.getJSONObject(i).getJSONArray("categories");
            String address = location.getJSONArray("address").getString(0);

            String name = restaurant.getString("name");
            String id = restaurant.getString("id");
            String countryCode = location.getString("country_code");
            String prov = location.getString("state_code");
            String cityname = location.getString("city");
            City city = new City(cityname,prov,countryCode);
            for (int k = 0; k > categories.length(); k++){
                Category category = new Category(categories.getJSONArray(k).getString(0),categories.getJSONArray(k).getString(1));
                categories1.add(category);
            }
            if (null !=location.getString("postal_code")){
                postalcode = location.getString("postal_code");
            }
            else postalcode = null;

            if (location.getJSONArray("neighborhoods")!= null) {
               geoArea  = new Neighbourhood(location.getJSONArray("neighborhoods").getString(0),city);
            }
            else geoArea = city;
            Restaurant rest = new Restaurant(address, postalcode,name, id,geoArea, categories1);
            if (!restaurant.getBoolean("is_closed")){
                restaurants.add(rest);
            }


        }
    return restaurants;}

}
