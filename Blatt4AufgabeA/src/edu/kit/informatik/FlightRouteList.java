package edu.kit.informatik;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @version 1.0
 * @author uszjk
 * Diese Klasse Modelliert eine Liste aller Flugrouten
 */
public class FlightRouteList {
    
    private LinkedList<FlightRoute> routes;
    
    /**
     * Konstruktor einer Flugroutenliste
     */
    FlightRouteList() {
        routes = new LinkedList<FlightRoute>();
    }

    /**
     * 
     * @param values
     */
    public void add(String[] values) {
        
        if (isElement(values) == false) {
            routes.add(new FlightRoute(values));
            Collections.sort(routes);
            System.out.println("OK");
        }
        else {
            System.out.println("ERROR, Diese Flugzeugkennung gehört schon zu einer Route");
        }
    }
    
    /**
     * 
     * @param removealIDString
     */
    public void remove(String[] removealIDString) {
        boolean somethingRemoved = false;
        int removealID = Integer.parseInt(removealIDString[0]);
        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).getAircraftID() == removealID) {
                routes.remove(i);
                System.out.println("OK");
                somethingRemoved = true;
                break;
            }
        }
        if (somethingRemoved == false) {
            System.out.println("ERROR, Diese Flugzeugkennung gehört zu keiner Route 1");
        }
    }
    
    /**
     * 
     */
    public void printRoutes() {
        if (routes.isEmpty() == false) {
            for (FlightRoute flightRoute : routes)
                System.out.println(flightRoute);
        }
    }
    
    /**
     * 
     * @param parameters
     * @return true wenn die übergebene Flugroute in der Liste existiert
     */
    public boolean isElement(String[] parameters) {
        int checkID = Integer.parseInt(parameters[0]);
        for (FlightRoute flightRoute : routes) {
            if (flightRoute.getAircraftID() == checkID) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param parameters
     * @return Die FLugroute mit der Übergebenen FLugzeugkennung
     */
    public FlightRoute findFlightRoute(String[] parameters) {
        for (FlightRoute flightRoute : routes) {
            if (flightRoute.getAircraftID() == Integer.parseInt(parameters[0])) {
                return flightRoute;
            }
        }
        return null;
    }
}