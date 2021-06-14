package edu.kit.informatik;

import java.util.*;

/**
 * 
 * @author timch
 * @version 1.0
 *
 */
public class LockingSystem {
    
    private String[] configuration;
    private final int numberOfBolts;
    
    /**
     * 
     * @param startConfiguration
     */
    LockingSystem(String[] startConfiguration) {
        configuration = startConfiguration;
        numberOfBolts = configuration.length;
    }
    
    private String getBoltState (int bolt) {
        return configuration[bolt];
    }
  
    
    /**
     * 
     * @return 
     */
    public List<Integer> open() {
        throw new UnsupportedOperationException("Implementation missing");
    }
    
    /**
     * 
     * @return
     */
    public List<Integer> close() {
        throw new UnsupportedOperationException("Implementation missing");
    }
}
