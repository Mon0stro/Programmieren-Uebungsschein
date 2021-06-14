package edu.kit.informatik;

/**
 * @version 1.0
 * @author uszjk
 * Diese Klasse wird dient als Startpunkt des Programms und enthält nur die
 * Main Methode
 */
public class Application {
    
    /**
     * @param args
     * Mainmethode
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        while (ui.getQuit() != true) {
            ui.command();
        }
    }
}