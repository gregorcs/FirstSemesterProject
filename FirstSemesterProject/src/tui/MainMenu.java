package tui;

import input.KeyboardInput;

public class MainMenu {
	
	//Initialise variables
	private KeyboardInput kbInput;
	
	//constructor
	public MainMenu() {
		kbInput = new KeyboardInput();
	}
	
	//start method to call 
	public void start() {
		printIntro();
		mainMenu();
	}
	
	//main menu input and output
	private void mainMenu() {
		boolean isRunning = true;
		int input;
		
		while(isRunning) {
			printMainMenu();
			input = kbInput.intInput();
			
			switch(input) {
				case 1:
					System.out.println("to do");
					break;
				case 2:
					System.out.println("to do");
					break;
				case 3:
					ProductTui prodMenu = new ProductTui();
					prodMenu.start();
					break;
				case 4: 
					System.out.println("to do");
					break;
				case 0:
					isRunning = false;
					printGoodbye();
					break;
				default:
					errorMessage();
					break;
			}
		}
	}
	//Print statements 
	private void printMainMenu() {
		System.out.println("****** Main menu ******");
        System.out.println(" (1) Create order");
        System.out.println(" (2) Edit customers");
        System.out.println(" (3) Product menu");
        System.out.println(" (4) Discounts");
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choice:");
	}
	private void printIntro() {
		System.out.println("Shopping in Vestbjerg Byggecenter");
	}
	private void printGoodbye() {
		System.out.println("Thank you for shopping with us!");
	}
	private void errorMessage() {
		System.out.println("Input does not match menu, try again: ");
	}
}
