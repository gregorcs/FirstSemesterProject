package tui;

import input.KeyboardInput;
import loanFolder.Loan;
import loanFolder.LoanContainer;
import loanFolder.LoanProductContainer;

import java.util.ArrayList;

import controller.LoanController;
import controller.ProductForLoanController;
import model.PersonFolder.Person;
import model.ProductFolder.ProductForLoan;

public class LoanTui {
	
	private ProductForLoanController lpController;
	private LoanController loanController;
	private ProductTuiEdit prodTuiEdit;
	private KeyboardInput kbInput;

	public LoanTui() {
		lpController = new ProductForLoanController();
		loanController = new LoanController();
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
					//CONTINUE HERE
					//TODO
					//FIX UP THE LOANPRODUCT CLASS SO THAT IT FILLS THE ARRAY, THEN CLEAN UP THE CODE AND EDGE CASES
					break;
				case 3:
					printAllLoans();
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
	
	public void printAllLoans() {
		for (Loan loan : LoanContainer.getInstance().getLoansDatabase()) {
			printLoanInformation(loan);
		}
	}
	
	public void printLoanInformation(Loan loan) {
		Person borrower = loan.getBorrower();
		System.out.println("----------------LOAN----------------");
		System.out.println("ID of loan: " + loan.getID());
		System.out.println("Name of borrower: " + borrower.getUsername());
		System.out.println("Period rented in days: " + loan.getPeriod());
		printProductsInLoan(loan.getToLoanList());
		System.out.println("-------------END OF LOAN------------");	
	}
	
	public void printProductsInLoan(ArrayList<ProductForLoan> al) {
		for (ProductForLoan product : al) {
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