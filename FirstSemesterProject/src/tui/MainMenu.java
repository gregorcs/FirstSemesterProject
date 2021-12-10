package tui;

import controller.PersonController;
import input.KeyboardInput;

public class MainMenu {
	
	private static MainMenu instance;
	
	//Initialize variables
	private KeyboardInput kbInput;
	private boolean isLoggedIn = false;
	
	public static MainMenu getInstance() {
		if(instance == null) {
			instance = new MainMenu();
		}
		return instance;
	}
	
	//constructor
	/*public MainMenu() {
		kbInput = new KeyboardInput();
	}*/
	
	//start method to call 
	public void start() {
		printIntro();
		mainMenu();
	}
	
	//main menu input and output
	public void mainMenu() {
		kbInput = new KeyboardInput();
		boolean isRunning = true;
		int input;
		
		while(isRunning) {
			printMainMenu();
			input = kbInput.intInput();
			
			/*
			 * I made separate register and login menus/methods to deal with the whole "need an
			 * account before you do anything" situation.
			 *
			 * User settings (for changing the username/password, deleting an account and getting a
			 * complete overview of all accounts) & log out only appear if the user is logged in.
			 * Similarly, the Register & log in menus only appear if no user is logged in at the time.
			 * 
			 * ~Max
			 */
			
			 if (!isLoggedIn) {
				 PersonController percontrol = new PersonController();
				 switch(input) {
				 case 1:
					 // Registration Process
					 percontrol.createObj();
					 isLoggedIn = true;
					 break;
				 case 2:
					 percontrol.logIn();
					 isLoggedIn = true;
					 break;
				 case 0:
					 isRunning = false;
					 printGoodbye();
					 break;
				 default:
					 errorMessage();
					 break;
				}
			 } else {
			  	switch(input) {
				case 1:
					System.out.println("To-Do -- Create Order");
					break;
				case 2:
					System.out.println("To-Do -- Edit Customers");
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
					isLoggedIn = false;
					mainMenu();
					break;
				default:
					errorMessage();
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
		   } else {
		    System.out.println("****** Main Menu ******");
		    System.out.println(" (1) Create Order");
		    System.out.println(" (2) Edit Customers");
		    System.out.println(" (3) Product Menu");
		    System.out.println(" (4) Discounts");
		    System.out.println(" (5) User Settings");
		    System.out.println(" (0) Log Out");
		    System.out.print("\n Choice:");
		   }	 
	}
	
	private void printIntro() {
		System.out.println("Shopping in Vestbjerg Byggecenter");
	}
	
	private void printGoodbye() {
		System.out.println("Thank you for shopping with us!");
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