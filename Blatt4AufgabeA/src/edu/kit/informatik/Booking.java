package edu.kit.informatik;

/**
 * @version 1.0
 * @author uszjk
 * Diese Klasse modelliert eine Buchung welche sich aus einem Kunden
 * und einer gebuchten Flugroute zusammensetzt.
 */
public class Booking {
    private Customer bookingCustomer;
    private FlightRoute bookingRoute;
    private int billID;
    
    /**
     * 
     * @param billID
     * @param bookingCustomer
     * @param bookingRoute
     * Konstruktor für eine Buchung
     */
    public Booking(int billID, Customer bookingCustomer, FlightRoute bookingRoute) {
        this.billID = billID;
        this.bookingCustomer = bookingCustomer;
        this.bookingRoute = bookingRoute;
    }
    
    /**
     * @return Buchung als String
     */
    public String toString( ) {
        return bookingCustomer.getCustomerID() + ";" + bookingRoute.getAircraftID() + ";" + billID;
    }
    
    /**
     * 
     * @return Flugzeugkennung einer bestimmten Buchung
     */
    public int getAircraftID() {
        return bookingRoute.getAircraftID();
    }
}