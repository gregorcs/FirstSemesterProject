package controller;

import input.KeyboardInput;
import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;

public class ProductController implements InterfaceController<ProductForSale> {

	private KeyboardInput keyboard;
	
	public ProductController() {
		keyboard = new KeyboardInput();
	}
	
	@Override
	public void createObj() {
    	int  amount, minAmount, maxAmount;
    	double price;
    	boolean isAvailable = false;
    	ProductForSale pForSale;
    	String name, location;
    	
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
		isAvailable = (amount > 0) ? true : false;
		
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
                } else {
                    printTryAgain();
                    input = keyboard.intInput();
                }
            }
            return input;
        } else {
            printUnavailable();
        }
        return input;
    }

	private void printTryAgain() {
			System.out.println("Incorrect, try again!");
		
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
	public void printAskForProducts() {
        System.out.println("Press -1 to stop or any other number to continue: ");
    }
	public void printSuccess() {
		System.out.println("Item edited successfully");
	}

	public void printUnavailable() {
		System.out.println("Unavailable product");
	}

}
