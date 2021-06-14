package edu.kit.informatik;

import java.util.LinkedList;

/**
 * @version 1.0
 * @author uszjk
 * Diese Klasse Modelliert eine Liste in der alle Kunden gespeichert werden
 */
public class CustomerList {

    private LinkedList<Customer> customers;
    private int iDCount;

    /**
     * Konstrukter für eine Kundenliste
     */
    CustomerList() {
        customers = new LinkedList<Customer>();
        iDCount = 0;
    }

    /**
     * 
     * @param parameters
     * @return true wenn der angegebene Kunde bereits in der Liste existiert
     */
    public boolean existingCustomer(String[] parameters) {
        for (Customer customer : customers) {
            if (customer.getFirstName().equals(parameters[1]) && customer.getLastName().equals(parameters[2])) {
                return true;
                
            }
        }
        return false;
    }
    
    private int getIDCount() {
        return iDCount;
    }
    
    private void incrementIDCount() {
        iDCount++;
    }

    /**
     * 
     * @param parameters
     */
    public void addCustomer(String[] parameters) {
        customers.add(new Customer(getIDCount() + 1, parameters[1], parameters[2]));
        incrementIDCount();
    }

    /**
     * 
     * @param parameters
     * @return Den Nutzer mit dem Übergebenen vor- und nachnamen
     */
    public Customer findCustomer(String[] parameters) {
        for (Customer customer : customers) {
            if (customer.getFirstName() == parameters[1] && customer.getLastName() == parameters[2]) {
                return customer;
            }
        }
        return null;
    }
}