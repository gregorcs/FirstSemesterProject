package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.PersonContainer;

public class UserSettingsMenu {
	KeyboardInput kbInput = new KeyboardInput();
	MainMenu mm = MainMenu.getInstance();
	PrintOuts po = new PrintOuts();
	PersonController percontrol = new PersonController();
	PersonContainer percon = PersonContainer.getInstance();
	private boolean isRunning = true;
	
	public void start(String s) {
		USM(s);
	}
	
	public void USM(String role) {
		int kbChoice;
		while(isRunning) {
			po.printUSM(role);
			kbChoice = kbInput.intInput();
			if(role.equals("A")) {
				adminSettingsMenu(kbChoice);
			}else if(role.equals("E")) {
				employeeSettingsMenu(kbChoice);
			}else po.printRoleError();			
		}
	}
	
	private void adminSettingsMenu(int kbChoice) {
			switch(kbChoice) {
			case 1:
				percontrol.updateUN();
				break;
			case 2:
				updatePass();
				break;
			case 3:
				readAll();
				break;
			case 0:
				back();
				break;
			default:
				po.errorMessage();
				break;
		}
	}
	
	private void employeeSettingsMenu(int kbChoice) {
		switch(kbChoice) {
		case 1:
			updatePass();
			break;
		case 2:
			readAll();
			break;
		case 0:
			back();
			break;
		default:
			po.errorMessage();
			break;
		}
	}
	private void updatePass() {
		percontrol.updatePass();
	}
	
	private void readAll() {
		percon.readAll();
	}
	
	private void back() {
		isRunning = false;
	}
}
