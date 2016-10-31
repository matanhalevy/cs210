package ca.ubc.cs.cpsc210.quiz.google;

import ca.ubc.cs.cpsc210.quiz.model.Leg;
import ca.ubc.cs.cpsc210.quiz.model.Route;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Parser for response from Google Directions API.
 */
public class GoogleDirectionsParser {
    public Route route;



    public static Route parseRoute(String response) throws JSONException {



        Route route = new Route();
        JSONObject obj = new JSONObject(response);
        JSONArray legs = obj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs");





        for (int i = 0; i<legs.length();i++) {
            Leg leg = new Leg();
            leg.setDistance(legs.getJSONObject(i).getJSONObject("distance").getInt("value"));
            JSONArray steps = legs.getJSONObject(i).getJSONArray("steps");

            for (int k = 0; k < steps.length(); k++) {
               leg.addAllPoints(PolylineDecoder.decodePoly(steps.getJSONObject(k).getJSONObject("polyline").getString("points")));
               }

            route.addLeg(leg);

        }
    return route;}}






