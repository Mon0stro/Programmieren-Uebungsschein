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
    private static final String ERROR_MSG_UNKNOW_COMMAND = "ERROR, Dieser Befehl existiert nicht";

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
        if (input.length == 1) {
            switch (input[0]) {
                case CMD_QUIT:
                    quit = true;
                    break;    
                case CMD_OPEN:
                    lockingSystem.open();
                    break;    
                case CMD_CLOSE:
                    lockingSystem.close();
                    break;
                    
                case "moveable":
                    System.out.println(lockingSystem.moveable(Integer.parseInt(input[1])));
                    
                default:
                    System.out.println(ERROR_MSG_UNKNOW_COMMAND);
            }
        }
        else if (input.length == 2) {
            if (input[0].equals(CMD_INIT)) {
                String[] check = input[1].split(",");
                if (checkInit(check) == true) {
                    lockingSystem = new LockingSystem(check);
                    for (int i = 0; i<check.length; i++) {
                        System.out.println(i+1 + " " + lockingSystem.moveable(i));
                    }
                }
                else {
                    System.out.println(ERROR_MSG_UNKNOW_COMMAND);
                }
            }
            else {
                System.out.println(ERROR_MSG_UNKNOW_COMMAND);
            }
        }
        else {
            System.out.println(ERROR_MSG_UNKNOW_COMMAND);
        }
    }
    
    private boolean checkInit(String[] check) {
        for (int i = 0; i < check.length; i++) {
            if ((check[i].equals("auf") || check[i].equals("zu")) == false) {
                return false;
            }
        }
        return true;
    }
}