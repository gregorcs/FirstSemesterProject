package controller;

import input.KeyboardInput;
import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;

public class ProductController implements InterfaceController<ProductForSale> {

	private KeyboardInput keyboard;
	
	public ProductController() {
		keyboard = new KeyboardInput();
	}
	
	/*CRUD METHODS*/
	
	@Override
	public void createObj() {
    	int amount;						//Amount of copies a ProductForSale can hold
    	int minAmount;					//Minimum amount allowed to be stored
    	int maxAmount;					//Maximum amount -||-
    	double price;					
    	boolean isAvailable = false;	
    	ProductForSale pForSale;
    	String name;
    	String location;				//Location inside the store
    	
    	printCreateProdHeader();
    	printAskName();
		name = keyboard.stringInput();
    	printAskAmount();
		amount = keyboard.intInput();
		printAskPrice();
		price = keyboard.doubleInput();
		printAskLocation();
		location = keyboard.stringInput();
		
		int[] minAndMaxList = getMinAndMaxAmount();
		minAmount = minAndMaxList[0];
		maxAmount = minAndMaxList[1];
		isAvailable = checkAvailability(amount);
		
		//create object
		pForSale = new ProductForSale(amount, name, location, price, isAvailable, minAmount, maxAmount);
		ProductContainer.getInstance().create(pForSale);
	}
	
	@Override
	public ProductForSale getObj() {
		return ProductContainer.getInstance().searchForObj(askForID());
	}

	@Override
	public void updateObj() {
		int userChoice = keyboard.intInput();
		ProductForSale prodForSale = getObj();
		boolean isRunning = true;
		
		while (isRunning) {
			switch (userChoice) {
				case 1:
					printAskAmount();
					int amount = keyboard.intInput();
					prodForSale.setAmount(amount);
					prodForSale.setAvailable(checkAvailability(amount));
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
				case 5:
					int [] minMaxList = getMinAndMaxAmount();
					int minAmount = minMaxList[0];
					int maxAmount = minMaxList[1];
					prodForSale.setMinimumAmount(minAmount);
					prodForSale.setMaximumAmount(maxAmount);
					break;
				case 0:
					isRunning = false;
					break;
				default: 
					System.out.println("Something went wrong, try again: ");
					break;
			}
		}
	}
	
	@Override
	public void deleteObj() {
		ProductForSale product = getObj();
		
		if (product != null) {
			ProductContainer.getInstance().delete(product);
			printSuccess();
		}
		else {
			printUnavailable();
		}
	}
	
	public int askForID() {	
		int input = 0;
		
		if (ProductContainer.getInstance().arraySize() > 0) {
			boolean isCorrect = false;
			printAskforID();
			input = keyboard.intInput();
			
			while (!isCorrect) {
				
				if (ProductContainer.getInstance().searchForObj(input) != null) {
					return input;
				}
				else {
					printTryAgain();
					input = keyboard.intInput();
				}
			}
			return input;
		}
		else {
			printEmpty();
		}
		return input;
	}

	public int[] getMinAndMaxAmount() {
		 int[] resultArr = {0, -1};
		 int minAmount;
		 int maxAmount;
		 boolean correctInput = false;
		 
		 while (!correctInput) {
			printAskMinStock();
			minAmount = keyboard.intInput();
			printAskMaxStock();
			maxAmount = keyboard.intInput();
			
			correctInput = (minAmount < maxAmount) ? true : false;
			
			if (correctInput) {
				resultArr[0] = minAmount;
				resultArr[1] = maxAmount;
			}
		 }
		 return resultArr;
	}
	
	public boolean checkAvailability(int amount) {
		return (amount > 0) ? true : false;
	}
	
	/*Print statements*/
	
	private void printAskMinStock() {
		System.out.println("Enter minimum stock amount: ");
	}
	
	public void printCreateProdHeader() {
    	System.out.println("****** Create product for sale******");
    	System.out.println("************************************");
	}
	
	private void printAskMaxStock() {
		System.out.println("Enter maximum stock amount: ");
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
		System.out.println("Please enter ID of the product: ");
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
