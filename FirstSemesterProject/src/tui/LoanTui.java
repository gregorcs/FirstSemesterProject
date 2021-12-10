package tui;

import input.KeyboardInput;
import controller.LoanController;
import controller.LoanProductController;
import model.LoanProductContainer;
import model.ProductFolder.ProductForLoan;

public class LoanTui {
	
	private LoanProductController lpController;
	private LoanController loanController;
	private ProductTuiEdit prodTuiEdit;
	private KeyboardInput kbInput;

	public LoanTui() {
		lpController = new LoanProductController();
		prodTuiEdit = new ProductTuiEdit();
		kbInput = new KeyboardInput();
	}
	
	public void start() {
		boolean isRunning = true;
		int kbChoice;
		
		while(isRunning) {
			writeLoanMenu();
			kbChoice = kbInput.intInput();
			
			switch(kbChoice) {
				case 1:
					loanController.createObj();
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
				case 6:
					System.out.println("to do");
					break;
				case 0:
					isRunning = false;
					break;
				default:
					break;
			}
		}
	}
	
	private void writeLoanMenu() {
		System.out.println("****** Loan Menu ******");
        System.out.println(" (1) Create loan");
        System.out.println(" (2) Product menu");
        System.out.println(" (3) Print active loans");
        System.out.println(" (4) Print all products");
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