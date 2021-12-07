package tui;

import controller.ProductController;
import input.KeyboardInput;
import model.ProductFolder.Product;

public class ProductMenu {
	
	private ProductController controller;
	private KeyboardInput kbInput;
	private MainMenu menu;

	public ProductMenu() {
		controller = new ProductController();
		kbInput = new KeyboardInput();
	}
	
	public void start() {
		boolean isRunning = true;
		int kbChoice;
		
		while(isRunning) {
			writeProductMenu();
			kbChoice = kbInput.intInput();
			
			switch(kbChoice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 0:
					menu = new MainMenu();
					menu.start();
					break;
				default:
					break;
				
			}
		}
		
	}
	
	private void writeProductMenu() {
		System.out.println("****** LP Menu ******");
        System.out.println(" (1) Create Product");
        System.out.println(" (2) Get Product");
        System.out.println(" (3) Update Product");
        System.out.println(" (4) Delete Product");
        System.out.println(" (0) Return to Main Menu");
        System.out.print("\n Choice:");
	}
    	
	
}
