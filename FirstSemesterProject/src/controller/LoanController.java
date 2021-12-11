package controller;

import java.util.ArrayList;

import input.KeyboardInput;
import loanFolder.Loan;
import loanFolder.LoanContainer;
import model.PersonFolder.Person;
import model.ProductFolder.ProductForLoan;

public class LoanController {

	private KeyboardInput keyboard;
	
	
	public LoanController() {
		keyboard = new KeyboardInput();
	}
	
	/*CRUD METHODS*/
	
	public void createObj() {
    	Person borrower = null;
    	Loan loan;
    	ArrayList<ProductForLoan> toLoanAL = new ArrayList<ProductForLoan>();
		int period;
    	
    	printCreateProdHeader();
    	printAskPerson();
    	askForID();
    	
    	printAskForProducts();
    	productsToLoan();
    	
    	printAskForPeriod();
    	period = keyboard.intInput();
		
		//create object
		loan = new Loan(borrower, toLoanAL, period);
		LoanContainer.getInstance().create(loan);
	}
	
	public Loan getObj() {
		return LoanContainer.getInstance().searchForObj(askForID());
	}

	public void updateObj() {
		int userChoice = keyboard.intInput();
		Loan loan = getObj();
		boolean isRunning = true;
		
		while (isRunning) {
			switch (userChoice) {
				default: 
					printTryAgain();
					//TODO
					loan.setBorrower(null);
					break;
			}
		}
	}
	
	public void deleteObj() {
		Loan product = getObj();
		
		if (product != null) {
			LoanContainer.getInstance().delete(product);
			printSuccess();
		} else {
			printUnavailable();
		}
	}
	
	public int askForID() {	
		int input = 0;
		
		if (LoanContainer.getInstance().arraySize() > 0) {
			boolean isCorrect = false;
			printAskforID();
			input = keyboard.intInput();
			
			while (!isCorrect) {
				if (LoanContainer.getInstance().searchForObj(input) != null) {
					return input;
				} else {
					printTryAgain();
					input = keyboard.intInput();
				}
			}
			return input;
		} else {
			printEmpty();
		}
		return input;
	}
	
	private ArrayList<ProductForLoan> productsToLoan() {
		ArrayList<ProductForLoan> al = new ArrayList<ProductForLoan>();
		
		return al;
	}
	
	/*Print statements*/
	
	
	public void printCreateProdHeader() {
    	System.out.println("****** Create new loan******");
    	System.out.println("************************************");
	}
	
	private void printAskPerson() {
		System.out.println("Enter the ID of the person: ");
	}
	
	public void printAskforID() {
		System.out.println("Enter ID of the product: ");
	}
	
	public void printSuccess() {
		System.out.println("Item edited successfully");
	}

	public void printUnavailable() {
		System.out.println("Unavailable product");
	}
	
	public void printEmpty() {
		System.out.println("Database is empty");
	}
	
	public void printTryAgain() {
		System.out.println("Incorrect! Try again: ");
	}
	
	public void printAskForProducts() {
		System.out.println("Enter ID of products to loan (-1 to stop): ");
	}
	
	public void printAskForPeriod() {
		System.out.println("Enter number of days to be rented: ");
	}
}
