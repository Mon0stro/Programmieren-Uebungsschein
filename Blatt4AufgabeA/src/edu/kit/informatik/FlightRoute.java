package edu.kit.informatik;


public class FlightRoute implements Comparable<FlightRoute>{
	private int aircraftID;
	private String start;
	private String destination;
	private int price;
	private Currency currency;
	
	
	FlightRoute (String[] values) {
		this.aircraftID = Integer.parseInt(values[0]);
		this.start = values[1];
		this.destination = values[2];
		this.price = Integer.parseInt(values[3]);
		this.currency = Currency.valueOf(values[4]);
	}
	
	public int GetAircraftID () {
		return aircraftID;
	}
	
	public String toString( ) {
	    String formatedPrice;
	    if (price < 10) {
	        formatedPrice = "0.0" + price;
	    }
	    else if (price%100 == 0) {
            formatedPrice = price/100 + ".00";
	    }
	    else if (price%100 < 10) {
            formatedPrice = price/100 + ".0" + price%100;
        }
	    else {
	        formatedPrice = price/100 + "." + price%100;
	    }
	    return aircraftID + ";" + start + ";" + destination + ";" + formatedPrice + ";" + currency;
	}
	
	 public int compareTo(FlightRoute otherFlightRoute) {
	        return Integer.compare(GetAircraftID(), otherFlightRoute.GetAircraftID());
	 }
	
}