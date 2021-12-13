package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.*;

public class UserSettingsMenu {
	private KeyboardInput kbInput;
	MainMenu mm;
	PersonController percontrol = new PersonController();
	PersonContainer percon = PersonContainer.getInstance();
	String role = percon.currentUser.getRole();
	
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
			printUSM();
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
					mm.errorMessage();
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
					mm.errorMessage();
					break;
				}
			}
			
		}
	}

	// Print Statements
	public void printUSM() {
		if (role.equals("A")) {
			System.out.println("****** User Settings Menu ******");
		    System.out.println(" (1) Change Username of Current Account");
		    System.out.println(" (2) Change Password of Current Account");
		    System.out.println(" (3) Show All Existing Accounts");
		    System.out.println(" (0) Return");
		    System.out.print("\n Choice:");
		    
		} else if (role.equals("E")) {
			System.out.println("****** User Settings Menu ******");
		    System.out.println(" (1) Change Password of Current Account");
		    System.out.println(" (2) Show All Existing Accounts");
		    System.out.println(" (0) Return");
		    System.out.print("\n Choice:");
		}
	}
}