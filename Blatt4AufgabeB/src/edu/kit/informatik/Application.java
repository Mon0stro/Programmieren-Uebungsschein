package edu.kit.informatik;

/**
 * kleiner Test
 * @author timch
 * @version 1.0
 *
 */
public class Application {
   
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        while (ui.getQuit() != true) {
            ui.command();
        }
    }
}