package edu.kit.informatik;

public class Application {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
        while (ui.getQuit() != true) {
            ui.command();
        }
	}

}
