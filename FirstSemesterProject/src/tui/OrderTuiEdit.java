package tui;

import input.KeyboardInput;

public class OrderTuiEdit {
	
	private KeyboardInput keyboard;

	public OrderTuiEdit() {
		keyboard = new KeyboardInput();
	}
	
	public void start() {
		boolean isRunning = true;
		int kbChoice;
		
		while(isRunning) {
			writeTuiEdit();
			kbChoice = keyboard.intInput();
			
			switch(kbChoice) {
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}
		}
	}
	
	private void writeTuiEdit() {
		System.out.println("****** Order Details ******");
        System.out.println(" (1) Enter customer ID");
        System.out.println(" (2) Add products");
        System.out.println(" (0) Cancel");
        System.out.println("\n Choice:");
	}
}
