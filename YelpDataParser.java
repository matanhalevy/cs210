package ca.ubc.cs.cpsc210.quiz.yelp;

import ca.ubc.cs.cpsc210.quiz.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Parser for JSON data returned by Yelp.
 */
public class YelpDataParser extends Object {

    public YelpDataParser() {}

    public static List<Restaurant> parseRestaurantData(String response, String yelpCityFilter) throws JSONException {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        if (yelpCityFilter == null)
            yelpCityFilter = "Vancouver";

        JSONObject object = new JSONObject(response);
        JSONArray businesses = object.getJSONArray("businesses");

        for (int i = 0; i < businesses.length(); i++) {
            JSONObject business = businesses.getJSONObject(i);
            JSONObject locationinfo = business.getJSONObject("location");

            if ((locationinfo.getString("city").equals(yelpCityFilter)) && (business.getBoolean("is_closed") == false)) {

                String name = business.getString("name");

                List<Category> categories = new ArrayList<Category>();
                JSONArray categories1 = business.getJSONArray("categories");
                for (int j = 0; j < categories1.length(); j++) {
                    String categoryname = categories1.getJSONArray(j).getString(0);
                    String alias = categories1.getJSONArray(j).getString(1);
                    Category category = new Category(categoryname, alias);
                    categories.add(category);
                }

                String postalCode = null;
                String id = "";
                String address = "";

                try {
                    id = business.getString("id");
                    address = locationinfo.getJSONArray("address").getString(0);
                    postalCode = locationinfo.getString("postal_code");
                } catch (JSONException e) {
                    System.out.println("No postal code or couldn't parse address or id");
                }

                GeoArea geoArea;
                String neighborhoodName;
                try {
                    JSONArray neighborhoods = locationinfo.getJSONArray("neighborhoods");
                    neighborhoodName = neighborhoods.getString(0);
                } catch (JSONException e) {
                    neighborhoodName = null;
                }

                String cityName;
                String province;
                String countryCode;
                City city = null;
                try {
                    cityName = locationinfo.getString("city");
                    province = locationinfo.getString("state_code");
                    countryCode = locationinfo.getString("country_code");
                    city = new City(cityName, province, countryCode);
                } catch (JSONException e) {
                    System.out.println("Couldn't parse city");
                }

                if (neighborhoodName != null)
                    geoArea = new Neighbourhood(neighborhoodName, city);
                else
                    geoArea = city;


                Restaurant restaurant = new Restaurant(name, categories, id, address, postalCode, geoArea);
                restaurants.add(restaurant);
            }
        }

        return restaurants;
    }
}

