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
    
    private static final String ERROR_MSG_UNKNOW_COMMAND = "ERROR, dieser Befehl existiert nicht";
    private static final String ERROR_MSG_WRONG_COMMAND_FORMAT = "ERROR, dieser Befehl wurde mit falschen Parametern "
    														   + "eingegeben.";

    private boolean quit;
    private final Scanner scanner;
    
    /**
     * 
     */
    UserInterface() {
        scanner = new Scanner(System.in);
        quit = false;
    }
    
    /**
     * 
     * @return
     */
    public boolean getQuit() {
        return quit;
    }
    /**
     * 
     */
    public void command() {
        String[] input = scanner.nextLine().split(" ");
        switch (input[0]) {	
        
        
        
        	case CMD_ADD:
        		if (input.length != 2) {
        			System.out.println(ERROR_MSG_WRONG_COMMAND_FORMAT);
        			break;
        		}
        		String[] parameter = input[1].split(";");
        		if (parameter.length != 5) {
        			System.out.println(ERROR_MSG_WRONG_COMMAND_FORMAT);
        			break;
        		}
        		try {
        			int tempAircraftID = Integer.parseInt(parameter[0]);
        			int tempPrice = Integer.parseInt(parameter[3]);
        			Currency tempCurrency = Currency.valueOf(parameter[4]);
        			String tempStart = parameter[1];
            		String tempDestination = parameter[2];
            		if (tempAircraftID > 0 && tempAircraftID < 100000 && tempPrice > 0) {
            			FlightRoute  = new FlightRoute(tempAircraftID, tempStart, tempDestination, tempPrice, tempCurrency);
            		}
        		}
        		catch (NumberFormatException e){
        			System.out.println(ERROR_MSG_WRONG_COMMAND_FORMAT + " Flugzeugkennung und Preis müssen eine Zahl sein!");
        		}
        		catch (IllegalArgumentException e) {
        			System.out.println(ERROR_MSG_WRONG_COMMAND_FORMAT + " must be EUR, USD, GBP, JPY");
        		}
        		break;
        		
        		
        		
        	case CMD_REMOVE:
        		if (input.length != 2) {
        			System.out.println(ERROR_MSG_WRONG_COMMAND_FORMAT);
        			break;
        		}
        		break;
        		
        		
        		
        	case CMD_LIST_ROUTE:
        		if (input.length != 1) {
        			System.out.println(ERROR_MSG_WRONG_COMMAND_FORMAT);
        			break;
        		}
        		break;
        		
        		
        		
        	case CMD_BOOK:
        		if (input.length != 2) {
        			System.out.println(ERROR_MSG_WRONG_COMMAND_FORMAT);
        			break;
        		}
        		break;
        	
        		
        		
        	case CMD_LIST_BOOKINGS:
        		if (input.length != 1) {
        			System.out.println(ERROR_MSG_WRONG_COMMAND_FORMAT);
        			break;
        		}
        		break;
        		
        		
        		
        	case CMD_QUIT:
        		if (input.length != 1) {
        			System.out.println(ERROR_MSG_WRONG_COMMAND_FORMAT);
        			break;
        		}
        		quit = true;
        		break;
        		
        		
        		
        	default:
        		System.out.println(ERROR_MSG_UNKNOW_COMMAND);
        }
    }
}