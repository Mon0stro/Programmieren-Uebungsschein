package edu.kit.informatik;

/**
 * @version 1.0
 * @author uszjk
 * Diese Klasse Modelliert eine Nutzereingabe bestehend aus dem Commando und seinen Parametern
 */
public class Input {

    private String command;
    private String[] parameter;
    
    /**
     * 
     * @param commandAndParameter
     * Konstruktor einer Nutzereingabe
     */
    Input(String commandAndParameter) {
        String[] split = commandAndParameter.split(" ");
        if (split.length == 1) {
            command = split[0];
        }
        else if (split.length == 2) {
            command = split[0];
            parameter = split[1].split(";");
        }
        else {
            System.out.print("Dieser Befehl existiert nicht");
        }
    }
    
    /**
     * 
     * @return Das eingegebene Commando als String
     */
    public String getCommand() {
        return command;
    }
    
    /**
     * 
     * @return Die eingegebenen Parameter als String
     */
    public String[] getParameters() {
        return parameter;
    }
    
    /**
     * 
     * @return true wenn alle Parameter den Vorraussetzungen für den add Befehl entsprechen
     */
    public boolean checkAdd() {
        if (parameter == null || parameter.length != 5 ) {
            System.out.println("ERROR, Parameter müssen <Fleugzeugkennung;Start;Ziel;Preis;Waehrung> sein");
            return false;
        }
        try {
            int aircraftID = Integer.parseInt(parameter[0]);
            double price = Double.parseDouble(parameter[3]);
            Currency currency = Currency.valueOf(parameter[4]);
            if (aircraftID > 0 && aircraftID < 100000 && price > 0) {
                return true;
            }
            else {
                System.out.println("ERROR, Flugzeugkennung und Preis müssen > 0, Flugzeugkennung < 100000 sein");
                return false;
            }
        }
        catch (NumberFormatException e) {
            System.out.println("ERROR, Flugzeugkennung und Preis müssen nummern sein");
            return false;
        }
        catch (IllegalArgumentException e) {
            System.out.println("ERROR, Währung muss EUR, GBP, USD oder JPY sein");
            return false;
        }
    }

    /**
     * 
     * @return true wenn alle Parameter den Vorraussetzungen für den remove Befehl entsprechen
     */
    public boolean checkRemove() {
        if (parameter == null || parameter.length != 1) {
            System.out.println("ERROR, Es darf nur <Flugzeugkennung> als Parameter eingegebne werden");
            return false;
        }
        try {
            int aircraftID = Integer.parseInt(parameter[0]);
            return true;
        }
        catch (NumberFormatException e) {
            System.out.println("ERROR, Flugzeugkennung muss nummern sein");
            return false;
        }
    }

    /**
     * 
     * @return true wenn alle Parameter den Vorraussetzungen für den list-route Befehl entsprechen
     */
    public boolean checkListRoute() {
        if (parameter != null) {
            System.out.println("ERROR, list-route wird ohne Parameter erwartet");
            return false;
        }
        return true;
    }

    /**
     * 
     * @return true wenn alle Parameter den Vorraussetzungen für den book Befehl entsprechen
     */
    public boolean checkBook() {
        if (parameter == null || parameter.length != 3 ) {
            System.out.println("ERROR, Parameter müssen <Fleugzeugkennung;Vorname;Nachname> sein");
            return false;
        }
        try {
            int aircraftID = Integer.parseInt(parameter[0]);
            return true;
        }
        catch (NumberFormatException e) {
            System.out.println("ERROR, Flugzeugkennung muss eine Nummer sein");
            return false;
        }
    }

    /**
     * 
     * @return true wenn alle Parameter den Vorraussetzungen für den list-bookings Befehl entsprechen
     */
    public boolean checkListBookings() {
        if (parameter != null) {
            System.out.println("ERROR, list-bookings wird ohne Parameter erwartet");
            return false;
        }
        return true;
    }

    /**
     * 
     * @return true wenn alle Parameter den Vorraussetzungen für den quit Befehl entsprechen
     */
    public boolean checkQuit() {
        if (parameter != null) {
            System.out.println("ERROR, quit wird ohne Parameter erwartet");
            return false;
        }
        return true;
    }
}
