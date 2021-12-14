package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.*;

public class AccManagementMenu {
	
	private KeyboardInput keyboard;
	MainMenu mm;
	PrintOuts po;
	PersonController percontrol = new PersonController();
	PersonContainer percon = PersonContainer.getInstance();
	boolean isRunning = true;
		
	public AccManagementMenu() {
		keyboard = new KeyboardInput();
		mm = MainMenu.getInstance();
	}
	
	public void start() {
		AMM();
	}
		
	public void AMM() {
		int input;
		
		while(isRunning) {
			po.printAMM();
			input = keyboard.intInput();
			accMngMenu(input);
		}
	}
		
	private void accMngMenu(int input) {
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
			isRunning = false;
			break;
		default:
			po.errorMessage();
			break;		
		}
	}	
}