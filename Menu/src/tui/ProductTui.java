package tui;

import controller.ProductController;
import input.KeyboardInput;
import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;

public class ProductTui {
	
	private ProductController pController;
	private ProductTuiEdit prodTuiEdit;
	private KeyboardInput kbInput;
	private boolean isRunning = true;

	public ProductTui() {
		pController = new ProductController();
		prodTuiEdit = new ProductTuiEdit();
		kbInput = new KeyboardInput();
	}
	
	public void start() {
		int kbChoice;
		
		while(isRunning) {
			writeProductMenu();
			kbChoice = kbInput.intInput();
			productMenu(kbChoice);
			
			
		}
	}
	

	private void writeProductMenu() {
		System.out.println("****** Manage Products ******");
        System.out.println(" (1) Create Product");
        System.out.println(" (2) Print specific product");
        System.out.println(" (3) Print all products");
        System.out.println(" (4) Update Product");
        System.out.println(" (5) Delete Product");
        System.out.println(" (0) Return to Main Menu");
        System.out.print("\n Choice:");
	}
	
	private void productMenu(int kbChoice) {
		switch(kbChoice) {
		case 1:
			pController.createObj();
			break;
		case 2:
			printProductForSale();
			break;
		case 3:
			printAllProductsForSale();
			break;
		case 4:
			prodTuiEdit.start();
			break;
		case 5:
			pController.deleteObj();
			break;
		case 0:
			isRunning = false;
			break;
		default:
			printTryAgain();
			break;
		}
	}
	
	
	public void printProductForSale() {	
		ProductForSale product = pController.getObj();
			
		if (product != null) {
			printProductInformation(product);	
		}
		else {
			pController = new ProductController();
			pController.printUnavailable();
		}
	}
	public void printAllProductsForSale() {
		//what do we do with this?
		for (ProductForSale product : ProductContainer.getInstance().getProductsDatabase()) {
			printProductInformation(product);
			System.out.println(ProductContainer.getInstance().arraySize());
		}
	}
	public void printProductInformation(ProductForSale product) {
		System.out.println("------------------------------------");
		System.out.println("ID: " + product.getID());
		System.out.println("Name of product: " + product.getName());
		System.out.println("Amount: " + product.getAmount());
		System.out.println("Price: " + product.getPrice() + "dkk");
		System.out.println("Availability: " + product.isAvailable());
		System.out.println("Physical location: " + product.getLocation());
		System.out.println("Minimum allowed in storage: " + product.getMinimumAmount());
		System.out.println("Maximum allowed in storage: " + product.getMaximumAmount());
		System.out.println("------------------------------------");		
	}
	public void emptyDatabase() {
		System.out.println("Nothing to print");
	}
	
	public void printTryAgain() {
		System.out.println("Invalid input detected. Please try again.");
	}
}
