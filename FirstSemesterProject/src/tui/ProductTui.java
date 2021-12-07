package tui;

import controller.ProductController;
import input.KeyboardInput;
import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;

public class ProductTui {
	
	private ProductController pController;
	private KeyboardInput kbInput;
	private MainMenu menu;

	public ProductTui() {
		pController = new ProductController();
		kbInput = new KeyboardInput();
	}
	
	public void start() {
		boolean isRunning = true;
		int kbChoice;
		menu = new MainMenu();
		
		while(isRunning) {
			writeProductMenu();
			kbChoice = kbInput.intInput();
			
			switch(kbChoice) {
				case 1:
					pController.createObj();
					menu.start();
					break;
				case 2:
					printProductForSale();
					break;
				case 3:
					printAllProductsForSale();
					break;
				case 4:
					//TO DO
					pController.updateObj();
					menu.start();
					break;
				case 5:
					pController.deleteObj();
					menu.start();
					break;
				case 0:
					menu.start();
					break;
				default:
					break;
			}
		}
	}
	
	private void writeProductMenu() {
		System.out.println("****** Create product for sale ******");
        System.out.println(" (1) Create Product");
        System.out.println(" (2) Print specific product");
        System.out.println(" (3) Print all products");
        System.out.println(" (4) Update Product");
        System.out.println(" (5) Delete Product");
        System.out.println(" (0) Return to Main Menu");
        System.out.print("\n Choice:");
	}
	public void printProductForSale() {	
		ProductForSale prod = pController.getObj();
		
	if (prod != null) {
		System.out.println("************************************");
		System.out.println("Name of product: " + prod.getName());
		System.out.println("Amount: " + prod.getAmount());
		System.out.println("Price: " + prod.getPrice() + "dkk");
		System.out.println("Availability: " + prod.isAvailable());
		System.out.println("Physical location: " + prod.getLocation());
		System.out.println("Minimum allowed in storage: " + prod.getMinimumAmount());
		System.out.println("Maximum allowed in storage: " + prod.getMaximumAmount());
		System.out.println("************************************");		
	}
	else {
		printUnavailable();
	}
}
	public void printAllProductsForSale() {
		//what do we do with this?
		for (ProductForSale prod : ProductContainer.getInstance().getProductsDatabase()) {
			System.out.println("to do " + prod.getName());
		}
	}
	public void emptyDatabase() {
		System.out.println("Nothing to print");
	}
	public void printSuccess() {
		System.out.println("Item edited successfully");
	}
	public void printAskforID() {
		System.out.println("Please enter ID of the product: ");
	}
	public void printUnavailable() {
		System.out.println("Unavailable product");
	}
	public void printCreateProdHeader() {
    	System.out.println("****** Create product for sale******");
    	System.out.println("************************************");
	}
}
