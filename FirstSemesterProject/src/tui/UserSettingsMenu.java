package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.*;

public class UserSettingsMenu {
	private KeyboardInput kbInput;
	
	public UserSettingsMenu() {
		kbInput = new KeyboardInput();
	}
	
	public void start() {
		USM();
	}
	
	public void USM() {
		boolean isRunning = true;
		int input;
		
		while(isRunning) {
			printUSM();
			input = kbInput.intInput();
			MainMenu mm = new MainMenu();
			PersonContainer percon = new PersonContainer();
			PersonController percontrol = new PersonController();
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
			case 4: 
				percontrol.deleteObj();
				break;
			case 0:
				mm.mainMenu();
				break;
			default:
				mm.errorMessage();
				break;
		}
	  }
	}

	// Print Statements
	public void printUSM() {
		System.out.println("****** User Settings Menu ******");
	    System.out.println(" (1) Change Username of Current Account");
	    System.out.println(" (2) Change Password of Current Account");
	    System.out.println(" (3) Show All Existing Accounts");
	    System.out.println(" (4) Delete Current Account");
	    System.out.println(" (0) Return");
	    System.out.print("\n Choice:");
	}
}