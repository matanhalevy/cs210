/**
 * A class that uses a LocationService to determine the current continent ---
 * via the whichContinent method.
 */
public class WhereAmI {


    /*
     * This method queries locator for Internet distances to the 7 continents
     * around the globe and returns the current continent name as a string.
     * 
     * EFFECTS: returns the current continent name as a string; one of the following
     *          seven strings: "North America", "South America", "Europe",
     *          "Asia", "Africa", "Australia", "Antarctica"
     */
    public String whichContinent(ILocationService locator) {
        if ((locator.timeTo(Continent.N_AMERICA) < locator.timeTo(Continent.S_AMERICA)) &&
                (locator.timeTo(Continent.N_AMERICA) < locator.timeTo(Continent.EUROPE)) &&
                (locator.timeTo(Continent.N_AMERICA) < locator.timeTo(Continent.ASIA)) &&
                (locator.timeTo(Continent.N_AMERICA) < locator.timeTo(Continent.AFRICA)) &&
                (locator.timeTo(Continent.N_AMERICA) < locator.timeTo(Continent.AUSTRALIA)) &&
                (locator.timeTo(Continent.N_AMERICA) < locator.timeTo(Continent.ANTARCTICA))) {
            return "North America";
        } else if ((locator.timeTo(Continent.S_AMERICA) < locator.timeTo(Continent.EUROPE)) &&
                (locator.timeTo(Continent.S_AMERICA) < locator.timeTo(Continent.ASIA)) &&
                (locator.timeTo(Continent.S_AMERICA) < locator.timeTo(Continent.AFRICA)) &&
                (locator.timeTo(Continent.S_AMERICA) < locator.timeTo(Continent.AUSTRALIA)) &&
                (locator.timeTo(Continent.S_AMERICA) < locator.timeTo(Continent.ANTARCTICA))) {
            return "South America";
        } else if ((locator.timeTo(Continent.EUROPE) < locator.timeTo(Continent.ASIA)) &&
                (locator.timeTo(Continent.EUROPE) < locator.timeTo(Continent.AFRICA)) &&
                (locator.timeTo(Continent.EUROPE) < locator.timeTo(Continent.AUSTRALIA)) &&
                (locator.timeTo(Continent.EUROPE) < locator.timeTo(Continent.ANTARCTICA))) {
            return "Europe";
        } else if ((locator.timeTo(Continent.ASIA) < locator.timeTo(Continent.AFRICA)) &&
                (locator.timeTo(Continent.ASIA) < locator.timeTo(Continent.AUSTRALIA)) &&
                (locator.timeTo(Continent.ASIA) < locator.timeTo(Continent.ANTARCTICA))) {
            return "Asia";
        } else if ((locator.timeTo(Continent.AFRICA) < locator.timeTo(Continent.AUSTRALIA)) &&
                (locator.timeTo(Continent.AFRICA) < locator.timeTo(Continent.ANTARCTICA))) {
            return "Africa";
        } else if ((locator.timeTo(Continent.AUSTRALIA) < locator.timeTo(Continent.ANTARCTICA))) {
            return "Australia";
        } else
            return "Antartica";
    }
}
