package tui;

import controller.LoanController;
import input.KeyboardInput;
import model.LoanProductContainer;
import model.ProductFolder.ProductForLoan;

public class LoanTui {
	
	private LoanController lpController;
	private ProductTuiEdit prodTuiEdit;
	private KeyboardInput kbInput;

	public LoanTui() {
		lpController = new LoanController();
		prodTuiEdit = new ProductTuiEdit();
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
					lpController.createObj();
					break;
				case 2:
					printProductForLoan();
					break;
				case 3:
					printAllProductsForLoan();
					break;
				case 4:
					prodTuiEdit.start();
					break;
				case 5:
					lpController.deleteObj();
					break;
				case 0:
					isRunning = false;
					break;
				default:
					break;
			}
		}
	}
	
	private void writeProductMenu() {
		System.out.println("****** Manage Products ******");
        System.out.println(" (1) Create loan");
        System.out.println(" (2) Print active loans");
        System.out.println(" (3) Print all products");
        System.out.println(" (4) Update Product");
        System.out.println(" (5) Delete Product");
        System.out.println(" (5) Return Loan");
        System.out.println(" (0) Return to Main Menu");
        System.out.print("\n Choice:");
	}
	public void printProductForLoan() {	
		ProductForLoan product = lpController.getObj();
		printProductInformation(product);	

	}
	public void printAllProductsForLoan() {
		for (ProductForLoan product : LoanProductContainer.getInstance().getProductsDatabase()) {
			printProductInformation(product);
		}
	}
	public void printProductInformation(ProductForLoan product) {
		System.out.println("------------------------------------");
		System.out.println("ID: " + product.getID());
		System.out.println("Name of product: " + product.getName());
		System.out.println("Amount: " + product.getAmount());
		System.out.println("Price: " + product.getPrice() + "dkk");
		System.out.println("Availability: " + product.isAvailable());
		System.out.println("Physical location: " + product.getLocation());
		System.out.println("------------------------------------");		
	}
	public void emptyDatabase() {
		System.out.println("Nothing to print");
	}
}