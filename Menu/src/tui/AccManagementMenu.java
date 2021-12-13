package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.*;

public class AccManagementMenu {
	
	private KeyboardInput kbInput;
	MainMenu mm;
	PrintOuts po;
	PersonController percontrol = new PersonController();
	PersonContainer percon = PersonContainer.getInstance();
	boolean isRunning = true;
		
	
	public AccManagementMenu() {
		kbInput = new KeyboardInput();
		mm = MainMenu.getInstance();
	}
	
	public void start() {
		AMM();
	}
		
	public void AMM() {
		int kbChoice;
		
		while(isRunning) {
			po.printAMM();
			kbChoice = kbInput.intInput();
			accMngMenu(kbChoice);
		}
	}
		
	private void accMngMenu(int kbChoice) {
		switch(kbChoice) {
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