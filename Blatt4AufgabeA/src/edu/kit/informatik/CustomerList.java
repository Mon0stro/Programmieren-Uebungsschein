package edu.kit.informatik;

import java.util.LinkedList;

public class CustomerList {

    private LinkedList<Customer> customers;
    private int iDCount;
    
    CustomerList () {
        customers = new LinkedList<Customer>();
        iDCount = 0;
    }
}
