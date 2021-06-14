package edu.kit.informatik;

import java.util.Collections;
import java.util.LinkedList;

public class FlightRouteList {
    
    private LinkedList<FlightRoute> routes;
    
    FlightRouteList () {
        routes = new LinkedList<FlightRoute>();
    }
    
    public void add (String[] values) {
        
        if (isElement(values[0]) == false) {
            routes.add(new FlightRoute(values));
            Collections.sort(routes);
            System.out.println("OK");
        }
        else {
            System.out.println("ERROR, Diese Flugzeugkennung gehört schon zu einer Route");
        }
    }
    
    public void remove(String[] removealIDString) {
        boolean somethingRemoved = false;
        int removealID = Integer.parseInt(removealIDString[0]);
        for(int i = 0; i<routes.size(); i++) {
            if (routes.get(i).GetAircraftID() == removealID) {
                routes.remove(i);
                System.out.println("OK");
                somethingRemoved = true;
                break;
            }
        }
        if (somethingRemoved == false) {
            System.out.println("ERROR, Diese Flugzeugkennung gehört zu keiner Route");
        }
    }
    
    public void print () {
        if (routes.isEmpty() == false) {
            for(FlightRoute flightRoute : routes)
                System.out.println(flightRoute);
        }
    }
    
    public boolean isElement (String checkIDString) {
        int checkID = Integer.parseInt(checkIDString);
        for(FlightRoute flightRoute : routes) {
            if (flightRoute.GetAircraftID() == checkID) {
                return true;
            }
        }
        System.out.println("ERROR, Diese Flugzeugkennung gehört zu keiner Route");
        return false;
    }
}
