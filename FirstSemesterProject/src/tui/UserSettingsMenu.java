package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.*;

public class UserSettingsMenu {
	KeyboardInput keyboard = new KeyboardInput();
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
			po.printUSM(role);
			kbChoice = keyboard.intInput();
			if(role.equals("A")) {
				adminSettingsMenu(kbChoice);
			}else if(role.equals("E")) {
				employeeSettingsMenu(kbChoice);
			}else po.printRoleError();
		}
	}
}
