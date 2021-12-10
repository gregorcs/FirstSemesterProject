package controller;

import java.util.ArrayList;

import input.KeyboardInput;
import model.Loan;
import model.LoanContainer;
import model.LoanProductContainer;
import model.Person;
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
		double price;
		int ID;
		int period;
    	
    	printCreateProdHeader();
    	printAskPerson();
    	askForID();
    	
    	printAskForProducts();
    	productsToLoan();
    	
    	printAskForPeriod();
    	period = keyboard.intInput();
		printAskPricePerDay();
		price = keyboard.doubleInput();
		
		//create object
		loan = new Loan(borrower, toLoanAL, period);
		LoanContainer.getInstance().create(loan);
	}
	
	public ProductForLoan getObj() {
		return LoanProductContainer.getInstance().searchForObj(askForID());
	}

	public void updateObj() {
		int userChoice = keyboard.intInput();
		ProductForLoan prodForSale = getObj();
		boolean isRunning = true;
		
		while (isRunning) {
			switch (userChoice) {
				case 1:
					printAskPerson();
					int amount = keyboard.intInput();
					prodForSale.setAmount(amount);
					isRunning = false;
					break;
				case 2:
					printAskPerson();
					prodForSale.setName(keyboard.stringInput());
					isRunning = false;
					break;
				case 3:
					printAskForPeriod();
					prodForSale.setLocation(keyboard.stringInput());
					isRunning = false;
					break;
				case 4:
					printAskPricePerDay();
					prodForSale.setPrice(keyboard.doubleInput());
					isRunning = false;
					break;
				case 0:
					isRunning = false;
					break;
				default: 
					printTryAgain();
					break;
			}
		}
	}
	
	public void deleteObj() {
		ProductForLoan product = getObj();
		
		if (product != null) {
			LoanProductContainer.getInstance().delete(product);
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
	
	private void printAskPricePerDay() {
		System.out.println("Enter the price per day: ");
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
