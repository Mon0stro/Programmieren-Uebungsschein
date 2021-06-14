package edu.kit.informatik;

/**
 * @version 1.0
 * @author uszjk
 * Diese Klasse Modelliert einen Kunden welcher eine Eindeutige Kundennummer
 * sie wie Vor- und Nachnamen hat
 */
public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    
    /**
     * 
     * @param customerID
     * @param firstName
     * @param lastName
     * Konstruktor für einen Kunden
     */
    Customer(int customerID, String firstName, String lastName) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * 
     * @return Vorname eines Kunden
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @return Nachname eines Kunden
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @return Kundennummer eines Kunden
     */
    public int getCustomerID() {
        return customerID;
    }
}