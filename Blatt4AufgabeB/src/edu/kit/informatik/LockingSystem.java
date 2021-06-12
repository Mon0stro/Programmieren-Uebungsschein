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
    
    public boolean moveable(int bolt) {
        if (bolt == 0) {
            return true;
        }
        else if (bolt == 1) {
            if (getBoltState(bolt-1).equals("zu")) {
                return false;
                }
            return true;
        }
        else if (bolt == numberOfBolts - 1) {
            for (int i = 0; i<numberOfBolts; i++) {
                if (configuration[i].equals("auf")) {
                    if (configuration[bolt-1].equals("auf")) {
                        for (int j = 0; j<bolt - 1; j++) {
                            if (configuration[j].equals("auf")) {
                                return false;
                            }
                        }
                        return true;
                    }
                    return false;
                }
            }
            return true;
        }
        else {
            if (configuration[bolt-1].equals("auf")) {
                for (int i = 0; i<bolt - 1; i++) {
                    if (configuration[i].equals("auf")) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }        
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
