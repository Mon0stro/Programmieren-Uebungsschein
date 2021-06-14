package edu.kit.informatik;

import java.util.LinkedList;

public class BookingList {
    
    private LinkedList<Booking> bookings;
    private int billCount;
    
    BookingList(){
        bookings = new LinkedList<Booking>();
        billCount = 0;
    }
}
