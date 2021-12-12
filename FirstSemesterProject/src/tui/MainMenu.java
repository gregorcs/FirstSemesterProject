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

	public static MainMenu getInstance() {
		if(instance == null) {
			instance = new MainMenu();
		}
		return instance;
	}

	public void start() {
		printIntro();
		mainMenu();
	}

	public void mainMenu() {
		kbInput = new KeyboardInput();
		boolean isRunning = true;
		int input;

		while(isRunning) {
			PersonController percontrol = new PersonController();

			 if (!isLoggedIn) {
				 printMainMenu();
				 input = kbInput.intInput();
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
					 percon.currentUser = null;
					 isRunning = false;
					 printGoodbye();
					 break;
				 default:
					 errorMessage();
					 break;
				}
			 } else {
				printMMLoggedIn();
				String role = percon.currentUser.getRole(); 
				if (!role.equals("C")) {
					input = kbInput.intInput();
				} else {
					input = 0;
				}
				
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
						ProductTui prodMenu = new ProductTui();
						prodMenu.start();
						break;
					case 4:
						System.out.println("To-Do -- Discounts");
						break;
					case 5:
						UserSettingsMenu usm = new UserSettingsMenu();
						usm.start();
						break;
					case 0:
						setIsLoggedIn(false);
						start();
						break;
					default:
						errorMessage();
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
						start();
						break;
					default:
						errorMessage();
						break;
				  	}
					
				case "C":
					printUnprivileged();
					setIsLoggedIn(false);
					start();
					break;
				  	}
				}
			 }
		}

	//Print statements
	private void printMainMenu() {
		if (!isLoggedIn) {
			System.out.println("****** Main Menu ******");
			System.out.println(" (1) Register");
		    System.out.println(" (2) Log In");
		    System.out.println(" (0) Quit the program");
		    System.out.print("\n Choice:");
		}
	}
	
	private void printMMLoggedIn() {
		String role = percon.currentUser.getRole(); 
		
		if (role.equals("A") || (role.equals("E"))) {
			   System.out.println("****** Main Menu ******");
			   System.out.println(" (1) Create Order");
			   System.out.println(" (2) Edit Customers");
			   System.out.println(" (3) Product Menu");
			   System.out.println(" (4) Discounts");
			   System.out.println(" (5) User Settings");
			   System.out.println(" (0) Log Out");
			   System.out.print("\n Choice:");
			   
		} else if (role.equals("E")) {
			System.out.println("****** Main Menu ******");
			   System.out.println(" (1) Create Order");
			   System.out.println(" (2) Product Menu");
			   System.out.println(" (3) Discounts");
			   System.out.println(" (4) User Settings");
			   System.out.println(" (0) Log Out");
		
		} else {
			System.out.println("****** Main Menu ******");
		}
	}

	private void printIntro() {
		System.out.println("Shopping in Vestbjerg Byggecenter");
	}

	private void printGoodbye() {
		System.out.println("Thank you for shopping with us!");
	}
	private void printUnprivileged() {
		System.out.println("Unfortunately, your account lacks the privileges required to display this page.");
	}
  
	void errorMessage() {
		System.out.println("Input does not match menu, try again: ");
	}

	public void setIsLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public boolean getIsLoggedIn() {
		return isLoggedIn;
	}
}
