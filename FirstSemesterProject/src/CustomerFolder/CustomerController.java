package CustomerFolder;

import input.KeyboardInput;
import tui.MainMenu;
import tui.PrintOuts;

public class CustomerController {
	private KeyboardInput keyboard;
	MainMenu mm;
	PrintOuts po = new PrintOuts();
	
	public CustomerController() {
		keyboard = new KeyboardInput();
		mm = MainMenu.getInstance();
	}
	
	public void createObj() {
		String name = keyboard.stringInput();
		// integer input, 1 = yes, 0 = no.
		boolean hasCraft;
		
		po.printCreateCusHeader();
		po.printSuccess();
		
		// Object Creation
		Customer C = new Customer(name, hasCraft);
		// Create Method
}
}