package controller;

import input.KeyboardInput;
import loanFolder.LoanProductContainer;
import model.ProductFolder.ProductForLoan;

public class ProductForLoanController {

	private KeyboardInput keyboard;
	
	public ProductForLoanController() {
		keyboard = new KeyboardInput();
	}
	
	/*CRUD METHODS*/
	
	public void createObj() {
    	int amount;
    	double price;					
    	boolean isAvailable = false;	
    	ProductForLoan pForSale;
    	String name;
    	String location;				
    	
    	printCreateProdHeader();
    	printAskName();
		name = keyboard.stringInput();
    	printAskAmount();
		amount = keyboard.intInput();
		printAskPrice();
		price = keyboard.doubleInput();
		printAskLocation();
		location = keyboard.stringInput();
		
		//create object
		pForSale = new ProductForLoan(amount, name, location, price, isAvailable);
		LoanProductContainer.getInstance().create(pForSale);
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
					printAskAmount();
					int amount = keyboard.intInput();
					prodForSale.setAmount(amount);
					isRunning = false;
					break;
				case 2:
					printAskName();
					prodForSale.setName(keyboard.stringInput());
					isRunning = false;
					break;
				case 3:
					printAskLocation();
					prodForSale.setLocation(keyboard.stringInput());
					isRunning = false;
					break;
				case 4:
					printAskPrice();
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
		
		if (LoanProductContainer.getInstance().arraySize() > 0) {
			boolean isCorrect = false;
			printAskforID();
			input = keyboard.intInput();
			
			while (!isCorrect) {
				if (LoanProductContainer.getInstance().searchForObj(input) != null) {
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
	
	/*Print statements*/
	
	
	public void printCreateProdHeader() {
    	System.out.println("****** Create product for sale******");
    	System.out.println("************************************");
	}
	
	private void printAskName() {
		System.out.println("Enter the name of the product for sale: ");
	}
	
	private void printAskAmount() {
		System.out.println("Enter the amount: ");
	}
	
	private void printAskPrice() {
		System.out.println("Enter the price: ");
	}
	
	private void printAskLocation() {
		System.out.println("Enter location of product: ");
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
}