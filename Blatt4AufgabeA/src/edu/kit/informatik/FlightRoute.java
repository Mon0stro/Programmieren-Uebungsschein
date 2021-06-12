package edu.kit.informatik;

public class FlightRoute {
	private int aircraftID;
	private String start;
	private String destination;
	private int price;
	private Currency currency;
	
	FlightRoute (int aircraftID, String start, String destination, int price, Currency currency) {
		this.aircraftID = aircraftID;
		this.start = start;
		this.destination = destination;
		this.price = price;
		this.currency = currency;
	}
	
}
