package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.*;

public class UserSettingsMenu {
	private KeyboardInput kbInput;
	MainMenu mm = MainMenu.getInstance();
	PrintOuts po = new PrintOuts();
	PersonController percontrol = new PersonController();
	PersonContainer percon = PersonContainer.getInstance();
	String role = percon.getCurrentUser().getRole();
	
	public UserSettingsMenu() {
		kbInput = new KeyboardInput();
		mm = MainMenu.getInstance();
	}
	
	public void start() {
		USM();
	}
	
	public void USM() {
		boolean isRunning = true;
		int input;
		
		while(isRunning) {
			po.printUSM();
			input = kbInput.intInput();
			
			switch (role) {
			case "A":
				switch(input) {
				case 1:
					percontrol.updateUN();
					break;
				case 2:
					percontrol.updatePass();
					break;
				case 3:
					percon.readAll();
					break;
				case 0:
					mm.mainMenu();
					break;
				default:
					po.errorMessage();
					break;
			}
				
			case "E":
				switch(input) {
				case 1:
					percontrol.updatePass();
					break;
				case 2:
					percon.readAll();
					break;
				case 0:
					mm.mainMenu();
					break;
				default:
					po.errorMessage();
					break;
				}
			}
		}
	}
}