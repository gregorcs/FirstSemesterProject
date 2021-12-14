package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.*;

public class MainMenu {

	private static MainMenu instance;

	private KeyboardInput keyboard;
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
		keyboard = new KeyboardInput();

		while(isRunning) {
			if (!(percon.getIsLoggedIn())) {
				po.printMainMenu();
				notLoggedInMenu();
			} else {
				checkRole();
			}
		}
	}

	private void notLoggedInMenu() {
		PersonController percontrol = new PersonController();
		int input = keyboard.intInput();
		switch(input) {
		case 1:
			percontrol.createObj();
			break;
		case 2:
			percontrol.logIn();
			break;
		case 0:
			po.printGoodbye();
			isRunning = false;
			break;
		default:
			po.errorMessage();
			notLoggedInMenu();
			break;
		}
	}

	private void checkRole() {
		role = percon.getCurrentUser().getRole();
		if(role == null) {
			po.printRoleError();

		} else if (role.equals("A")) {
			po.printAdminMenu();
			adminMenu();

		} else if (role.equals("E")) {
			po.printEmployeeMenu();
			employeeMenu();
		}
	}

	private void adminMenu() {
		int input = keyboard.intInput();
		switch(input) {
		case 1:
			order();
			break;
		case 2:
			accountManagement();
			break;
		case 3:
			customerMenu();
			break;
		case 4:
			productMenu();
			break;
		case 5:
			discountMenu();
			break;
		case 6:
			userSettings();
			break;
		case 0:
			logOut();
			break;
		default:
			po.errorMessage();
			adminMenu();
			break;
		}

	private void employeeMenu() {
		int input = keyboard.intInput();
		switch(input) {
		case 1:
			order();
			break;
		case 2:
			productMenu();
			break;
		case 3:
			discountMenu();
			break;
		case 4:
			userSettings();
			break;
		case 0:
			logOut();
			break;
		default:
			po.errorMessage();
			employeeMenu();
			break;
		}
	}

	private void order() {
		OrderTui ordMenu = new OrderTui();
		ordMenu.start();
	}

	private void customerMenu() {
		CustomerManageMenu cmm = new CustomerManageMenu();
		cmm.start();
	}

	private void productMenu() {
		ProductTui prodMenu = new ProductTui();
		prodMenu.start();
	}

	private void discountMenu() {
		DiscountTui discMenu = new DiscountTui();
		discMenu.start();
	}

	private void userSettings() {
		role = percon.getCurrentUser().getRole();
		UserSettingsMenu usm = new UserSettingsMenu();
		System.out.println(role);
		usm.start(role);
	}

	private void accountManagement() {
		AccManagementMenu amm = new AccManagementMenu();
		amm.start();
	}

	private void logOut() {
		percon.setIsLoggedIn(false);
		percon.setCurrentUser(null);
	}
}
