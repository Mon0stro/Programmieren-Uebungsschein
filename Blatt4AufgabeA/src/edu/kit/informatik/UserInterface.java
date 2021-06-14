package edu.kit.informatik;

import java.util.Scanner;

/**
 * 
 * @author timch
 * @version 1.0
 * 
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
    
    /**
     * 
     */
    UserInterface() {
        scanner = new Scanner(System.in);
        quit = false;
        flightRouteList = new FlightRouteList();
        customerList = new CustomerList();
    }

    public boolean getQuit() {
        return quit;
    }
    /**
     * 
     */
    public void command() {
        input = new Input (scanner.nextLine());
        switch (input.getCommand()) {	
        
        
            case CMD_ADD:
        		if (input.checkAdd() == false) {
        		    break;
        		}
        		flightRouteList.add(input.getParameters());
        		break;
        		
        		
            case CMD_REMOVE:
                if (input.checkRemove() == false) {
                    break;
                }
                flightRouteList.remove(input.getParameters());
        		
                
            case CMD_LIST_ROUTE:
                if (input.checkListRoute() == false) {
                    break;
                }
                flightRouteList.print();
                break;
                
                
            case CMD_BOOK:
                if (input.checkBook() == false) {
                    break;
                }
                System.out.println("TO DO");
                if (flightRouteList.isElement(input.getSpecificParameter(0)) == false) {
                    break;
                }
                
                break;
        		
  
            case CMD_LIST_BOOKINGS:
                if (input.checkListBookings() == false) {
                    break;
                }
                System.out.println("TO DO");
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