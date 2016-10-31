package ubc.cpsc210.list.FlightMapQ5;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yoram on 2014-12-02.
 */
public class FlightMap {
    private Set<Route> routes;

    public FlightMap(Set<Route> routes) {
        this.routes = new HashSet<Route>();
    }

    public void addRoute(Route r){
        if (!routes.contains(r)){
            routes.add(r);
        }
    }

    public void removeRoute(Route r){
        if (routes.contains(r)){
            routes.remove(r);
        }
    }

}
