package ubc.cpsc210.list.FlightMapQ5;

public class Route {
    private final Airport departure;
    private final Airport arrival;

    public Route(Airport depar, Airport arr) {
        this.departure = depar;
        this.arrival = arr;
    }

    public Airport getDepartureAirport(){
        return departure;
    }

    public Airport getArrivalAirport(){
        return arrival;
    }
}
