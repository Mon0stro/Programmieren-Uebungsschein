package edu.kit.informatik;

import java.util.Scanner;

/**
 * 
 * @author timch
 * @version 1.0
 * 
 */
public class UserInterface {
    
    private static final String CMD_QUIT = "quit";
    private static final String CMD_INIT = "init";
    private static final String CMD_OPEN = "open";
    private static final String CMD_CLOSE = "close";
    
    private static final String ERROR_MSG_UNKNOW_COMMAND = "ERROR, dieser Befehl wurde falsch eingegeben!";

    private boolean quit;
    private final Scanner scanner;
    private LockingSystem lockingSystem;
    
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
        
        
        
            case CMD_QUIT:
                if (input.length != 1) {
                    System.out.println(ERROR_MSG_UNKNOW_COMMAND + " Erwartet wird: <quit>");
                    break;
                }
                quit = true;
                break;
                
                
                
            case CMD_INIT:
                if (input.length != 2) {
                    System.out.println(ERROR_MSG_UNKNOW_COMMAND + " Erwartet wird: <init> <zustand>");
                    break;
                }
                if (checkInit(input[1]) == false) {
                    System.out.println(ERROR_MSG_UNKNOW_COMMAND + " Als Zustand ist nur auf und zu erlaubt");
                    break;
                }
                lockingSystem = new LockingSystem (input[1].split(","));
                break;
                
                
                
            case CMD_OPEN:
                if (input.length != 1) {
                    System.out.println(ERROR_MSG_UNKNOW_COMMAND + " Erwartet wird: <open>");
                    break;
                }
                break;
                
                
                
            case CMD_CLOSE:
                if (input.length != 1) {
                    System.out.println(ERROR_MSG_UNKNOW_COMMAND + " Erwartet wird: <close>");
                    break;
                }
                break;
                
                
            
            default: 
                System.out.println(ERROR_MSG_UNKNOW_COMMAND);
        }
    }
    
    private boolean checkInit(String state) {
        String[]bolts = state.split(",");
        for (int i = 0; i < bolts.length; i++) {
            if (bolts[i] != "auf" && bolts[i] != "zu") {
                return false;
            }
        }
        return true;
    }
}