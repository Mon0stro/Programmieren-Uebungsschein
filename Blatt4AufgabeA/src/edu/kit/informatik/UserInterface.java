package edu.kit.informatik;

import java.util.Scanner;

/**
 * @version 1.0
 * @author uszjk
 * Diese Klasse modelliert eine Nutzer Interface welches 
 * die Nutzereingaben verarbeitet und die eingegebnen Befehle ausführt
 */
public class UserInterface {
    
    private static final String CMD_ADD = "add";
    private static final String CMD_REMOVE = "remove";
    private static final String CMD_LIST_ROUTE = "list-route";
    private static final String CMD_BOOK = "book";
    private static final String CMD_LIST_BOOKINGS = "list-bookings";
    private static final String CMD_QUIT = "quit";
    
    private final Scanner scanner;
    private boolean quit;
    private Input input;
    private FlightRouteList flightRouteList;
    private CustomerList customerList;
    private BookingList bookingList;

    /**
     * Konstruktor für ein Nutzer Interface
     */
    UserInterface() {
        scanner = new Scanner(System.in);
        quit = false;
        flightRouteList = new FlightRouteList();
        customerList = new CustomerList();
        bookingList = new BookingList(customerList, flightRouteList);
    }

    /**
     * 
     * @return status der quit Variable
     */
    public boolean getQuit() {
        return quit;
    }

    /**
     * verarbeitet die eingabe und führt das entsprechende Kommando aus
     */
    public void command() {
        input = new Input(scanner.nextLine());
        switch (input.getCommand()) {    
        
        
            case CMD_ADD:
                if (input.checkAdd() == false) {
                    System.out.println("ERROR, Diese Flugzeugkennung gehört zu keiner Route");
                    break;
                }
                flightRouteList.add(input.getParameters());
                break;
                
                
            case CMD_REMOVE:
                if (input.checkRemove() == false) {
                    break;
                }
                flightRouteList.remove(input.getParameters());
                bookingList.removeBookings(input.getParameters());
                break;
                
            case CMD_LIST_ROUTE:
                if (input.checkListRoute() == false) {
                    break;
                }
                flightRouteList.printRoutes();
                break;
                
                
            case CMD_BOOK:
                if (input.checkBook() == false) {
                    break;
                }
                if (flightRouteList.isElement(input.getParameters()) == false) {
                    break;
                }
                if (customerList.existingCustomer(input.getParameters()) == false) {
                    customerList.addCustomer(input.getParameters());
                }
                Customer tempCustomer = customerList.findCustomer(input.getParameters());
                FlightRoute tempFlightRoute = flightRouteList.findFlightRoute(input.getParameters());
                bookingList.addBooking(tempCustomer, tempFlightRoute);
                break;
                
  
            case CMD_LIST_BOOKINGS:
                if (input.checkListBookings() == false) {
                    break;
                }
                bookingList.printBookings();
                break;
                
                
            case CMD_QUIT:
                if (input.checkQuit() == false) {
                    break;
                }
                quit = true;
                break;
                

            default:
                System.out.println("ERROR, Dieser Befehl existiert nicht");
        }
    }
}