package tui;

import input.KeyboardInput;
import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;


//TO DO, i'll finish this part up today
public class ProductTuiEdit {
	
	private KeyboardInput keyboard;
	private ProductContainer prodcon = ProductContainer.getInstance();
	public ProductTuiEdit() {
		keyboard = new KeyboardInput();
	}
	
	public void start() {
		boolean isRunning = true;
		int kbChoice;
		int prodToEdit;
		
		while(isRunning) {
			printProdToEdit();
			prodToEdit = keyboard.intInput();
			ProductForSale PFS = prodcon.searchForObj(prodToEdit);
			if (prodcon.productExists(PFS)) {
				writeTuiEdit();
				kbChoice = keyboard.intInput();
				switch(kbChoice) {
					case 1:
						printEditAmount();
						PFS.setAmount(keyboard.intInput());
						break;
					case 2:
						printEditName();
						PFS.setName(keyboard.stringInput());
						break;
					case 3:
						printEditLocation();
						PFS.setLocation(keyboard.stringInput());
						break;
					case 4:
						printEditPrice();
						PFS.setPrice(keyboard.doubleInput());
						break;
					case 5:
						PFS.setAvailable(isRunning);;
						break;
					case 6:
						PFS.setMinimumAmount(kbChoice);
						break;
					case 7:
						PFS.setMaximumAmount(kbChoice);
						break;
					case 0:
						isRunning = false;
					default:
						break;
				}
			} else {
				printUnvailable();
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
	
	private void printProdToEdit() {
		System.out.println("Enter ID of product you want to edit: ");
	}
	
	private void printUnvailable() {
		System.out.println("This item in not available");
	}
	private void printEditAmount() {
		System.out.println("Enter new amount: ");
	}
	private void printEditName() {
		System.out.println("Enter new name: ");
	}
	private void printEditLocation() {
		System.out.println("Enter new location: ");
	}
	private void printEditPrice() {
		System.out.println("Enter new price: ");
	}
}
