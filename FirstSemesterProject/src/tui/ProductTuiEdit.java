package tui;

import input.KeyboardInput;


//TO DO, i'll finish this part up today
public class ProductTuiEdit {
	
	private KeyboardInput keyboard;
	
	public ProductTuiEdit() {
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
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				default:
					break;
			}
		}
	}
	
	private void writeTuiEdit() {
		System.out.println("****** Edit Product Details ******");
        System.out.println(" (1) Edit amount");
        System.out.println(" (2) Edit name");
        System.out.println(" (3) Edit location");
        System.out.println(" (4) Edit price");
        System.out.println(" (5) Edit availability");
        System.out.println(" (6) Edit minimum amount");
        System.out.println(" (7) Edit maximum amount");
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choice:");
	}
}
