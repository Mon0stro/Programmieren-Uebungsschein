package edu.kit.informatik;

import java.util.LinkedList;

/**
 * @version 1.0
 * @author uszjk
 * Diese Klasse modelliert eine Liste in der alle Buchungen 
 * gespeichert werden
 */
public class BookingList {
    
    private LinkedList<Booking> bookings;
    private int billCount;
    
    /**
     * 
     * @param customers
     * @param routes
     * Konstruktor für eine Buchungsliste
     */
    BookingList(CustomerList customers, FlightRouteList routes) {
        bookings = new LinkedList<Booking>();
        billCount = 0;
    }
    
    private int getBillCount() {
        return billCount;
    }
    
    private void incrementBillCount() {
        billCount++;
    }
    
    /**
     * 
     * @param customerToAdd
     * @param flightRouteToAdd
     * fügt eine neue Buchung zur Liste hinzu
     */
    public void addBooking(Customer customerToAdd, FlightRoute flightRouteToAdd) {
        bookings.add(new Booking(getBillCount() + 1, customerToAdd, flightRouteToAdd));
        incrementBillCount();
        System.out.println(getBillCount() + ";" + customerToAdd.getCustomerID());
    }
    
    /**
     * gibt alle Elemente der Liste aus
     */
    public void printBookings() {
        if (bookings.isEmpty() == false) {
            for (Booking booking : bookings)
                System.out.println(booking);
        }
    }
    
    /**
     * 
     * @param removealIDString
     * entfernt alle Elemente mit eine betimmten Flugzeugkennung von der Liste
     */
    public void removeBookings(String[] removealIDString) {
        int removealID = Integer.parseInt(removealIDString[0]);
        for (int i = bookings.size() - 1; i >= 0; i--) {
            if (bookings.get(i).getAircraftID() == removealID) {
                bookings.remove(i);
            }
        }
    }
}