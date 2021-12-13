package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.*;

public class AccManagementMenu {
	
		private KeyboardInput kbInput;
		MainMenu mm;
		PersonController percontrol = new PersonController();
		PersonContainer percon = PersonContainer.getInstance();
		
		
		public AccManagementMenu() {
			kbInput = new KeyboardInput();
			mm = MainMenu.getInstance();
		}
		
		public void start() {
			AMM();
		}
		
		public void AMM() {
			boolean isRunning = true;
			int input;
			
			while(isRunning) {
				printAMM();
				
				input = kbInput.intInput();
				
					switch(input) {
					case 1:
						percontrol.updateUN();
						break;
					case 2:
						percontrol.updatePass();
						break;
					case 3: 
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

		public void printAMM() {
			System.out.println("****** Account Management Menu ******");
			System.out.println(" (1) Change Username of Selected Account");
		    System.out.println(" (2) Change Password of Selected Account");
		    System.out.println(" (3) Delete Selected Account");
		    System.out.println(" (0) Return");
		    System.out.print("\n Choice:");
		}
}