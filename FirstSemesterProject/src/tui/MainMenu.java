package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.*;

public class MainMenu {

	private static MainMenu instance;

	//Initialize variables
	private KeyboardInput kbInput;
	private boolean isLoggedIn = false;
	private PersonContainer percon = PersonContainer.getInstance();
	private PrintOuts po = new PrintOuts();
	

	public static MainMenu getInstance() {
		if(instance == null) {
			instance = new MainMenu();
		}
		return instance;
	}

	public void start() {
		po.printIntro();
		mainMenu();
	}

	public void mainMenu() {
		kbInput = new KeyboardInput();
		boolean isRunning = true;

		while(isRunning) {
			 if (!isLoggedIn) {
				 po.printMainMenu();
				 notLoggedInMenu();
			 } else { 
				po.printMainMenu();
				loggedInMenu();				
			}
		}
	}

	public void notLoggedInMenu() {
		 po.printMainMenu();
		 PersonController percontrol = new PersonController();
		 int input = kbInput.intInput();
		 switch(input) {
		 case 1:
			 // Registration Process
			 percontrol.createObj();
			 setIsLoggedIn(true);
			 break;
		 case 2:
			 percontrol.logIn();
			 setIsLoggedIn(true);
			 break;
		 case 0:
			 po.printGoodbye();
			 break;
		 default:
			 po.errorMessage();
			 break;
		 }
	}
	
	public void loggedInMenu() {
		int input = kbInput.intInput();
		String role = percon.getCurrentUser().getRole();
		switch(role) {
			case "A":
				switch(input) {
					case 1:
						OrderTui ordMenu = new OrderTui();
						ordMenu.start();
						break;
					case 2:
						AccManagementMenu amm = new AccManagementMenu();
						amm.start();
						break;
					case 3:
						CustomerManageMenu cmm = new CustomerManageMenu();
						cmm.start();
					case 4:
						ProductTui prodMenu = new ProductTui();
						prodMenu.start();
						break;
					case 5:
						System.out.println("To-Do -- Discounts");
						break;
					case 6:
						UserSettingsMenu usm = new UserSettingsMenu();
						usm.start();
						break;
					case 0:
						setIsLoggedIn(false);
						percon.setCurrentUser(null);
						start();
						break;
					default:
						po.errorMessage();
						break;
			  	}
				
			case "E":
				switch(input) {
					case 1:
						OrderTui ordMenu = new OrderTui();
						ordMenu.start();
						break;
					case 2:
						ProductTui prodMenu = new ProductTui();
						prodMenu.start();
						break;
					case 3:
						System.out.println("To-Do -- Discounts");
						break;
					case 4:
						UserSettingsMenu usm = new UserSettingsMenu();
						usm.start();
						break;
					case 0:
						setIsLoggedIn(false);
						percon.setCurrentUser(null);
						start();
						break;
					default:
						po.errorMessage();
						break;
			  	}
			}
		}
	
	// Setters n' Getters
		public void setIsLoggedIn(boolean isLoggedIn) {
			this.isLoggedIn = isLoggedIn;
		}

		public boolean getIsLoggedIn() {
			return isLoggedIn;
		}
}