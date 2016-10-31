package ubc.cpsc210.list.FlightMapQ5;

/**
 * Created by Yoram on 2014-12-02.
 */
public class Airport {
    private final String code;

    public Airport(String code) {
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;

        Airport airport = (Airport) o;

        if (!code.equals(airport.code)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
