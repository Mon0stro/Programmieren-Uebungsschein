package edu.kit.informatik;

/**
 * @version 1.0
 * @author uszjk
 * Diese Klasse Modelliert eine Flugroute welche eine Flugzeugkennung, Start und Ziel,
 * einen Preis und eine Währung besitzt
 */
public class FlightRoute implements Comparable<FlightRoute> {
    private int aircraftID;
    private String start;
    private String destination;
    private String price;
    private Currency currency;

    /**
     * 
     * @param values
     * Konstruktor für Flugroute
     */
    FlightRoute(String[] values) {
        this.aircraftID = Integer.parseInt(values[0]);
        this.start = values[1];
        this.destination = values[2];
        this.price = values[3];
        this.currency = Currency.valueOf(values[4]);
    }

    /**
     * 
     * @return Flugzeugkennung eine Flugroute
     */
    public int getAircraftID() {
        return aircraftID;
    }

    /**
     * @return Flugroute als String
     */
    public String toString( ) {
        return aircraftID + ";" + start + ";" + destination + ";" + price + ";" + currency;
    }

    /**
     * @param otherFlightRoute
     * @return vergleich zweier Flugrouten
     */
    public int compareTo(FlightRoute otherFlightRoute) {
        return Integer.compare(getAircraftID(), otherFlightRoute.getAircraftID());
    } 
}