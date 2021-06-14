package edu.kit.informatik;

public class Input {

    private String command;
    private String[] parameter;
    
    Input (String commandAndParameter) {
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
    
    public String getCommand() {
        return command;
    }
    
    public String[] getParameters() {
        return parameter;
    }
    
    public String getSpecificParameter(int parameterIndex) {
        return parameter[parameterIndex];
    }
    
    public boolean checkAdd() {
        if (parameter == null || parameter.length != 5 ) {
            System.out.println("ERROR, Parameter müssen <Fleugzeugkennung;Start;Ziel;Preis;Waehrung> sein");
            return false;
        }
        try {
            int aircraftID = Integer.parseInt(parameter[0]);
            int price = Integer.parseInt(parameter[3]);
            Currency currency = Currency.valueOf(parameter[4]);
            if (aircraftID > 0 && aircraftID < 100000 && price > 0) {
                return true;
            }
            else {
                System.out.println("ERROR, Flugzeugkennung und Preis müssen > 0 und Flugzeugkennung außerdem < 100000 sein");
                return false;
            }
        }
        catch (NumberFormatException e){
            System.out.println("ERROR, Flugzeugkennung und Preis müssen nummern sein");
            return false;
        }
        catch (IllegalArgumentException e) {
            System.out.println("ERROR, Währung muss EUR, GBP, USD oder JPY sein");
            return false;
        }
    }
    
    
    
    public boolean checkRemove() {
        if (parameter == null || parameter.length != 1) {
            System.out.println("ERROR, Es darf nur <Flugzeugkennung> als Parameter eingegebne werden");
            return false;
        }
        try {
            int aircraftID = Integer.parseInt(parameter[0]);
            return true;
        }
        catch (NumberFormatException e){
            System.out.println("ERROR, Flugzeugkennung muss nummern sein");
            return false;
        }
    }
    
    
    
    public boolean checkListRoute() {
        if (parameter != null) {
            System.out.println("ERROR, list-route wird ohne Parameter erwartet");
            return false;
        }
        return true;
    }
    
    
    
    public boolean checkBook() {
        if (parameter == null || parameter.length != 3 ) {
            System.out.println("ERROR, Parameter müssen <Fleugzeugkennung;Vorname;Nachname> sein");
            return false;
        }
        try {
            int aircraftID = Integer.parseInt(parameter[0]);
            return true;
        }
        catch (NumberFormatException e){
            System.out.println("ERROR, Flugzeugkennung muss eine Nummer sein");
            return false;
        }
    }
    
    
    
    public boolean checkListBookings() {
        if (parameter != null) {
            System.out.println("ERROR, list-bookings wird ohne Parameter erwartet");
            return false;
        }
        return true;
    }
    
    
    
    public boolean checkQuit() {
        if (parameter != null) {
            System.out.println("ERROR, quit wird ohne Parameter erwartet");
            return false;
        }
        return true;
    }
}
