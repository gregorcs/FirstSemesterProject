package controller;

import discountFolder.Discount;
import discountFolder.DiscountContainer;
import input.KeyboardInput;

public class DiscountController {
	
	private KeyboardInput keyboard;
		
	public DiscountController() {
		keyboard = new KeyboardInput();
	}

	//order creation
	public void createObj() {
		boolean isCorrect = false;
		int input = 0;
		
		printNewOrderHeader();
		
		while(!isCorrect) {
			printAskPerc();
			input = keyboard.intInput();
			isCorrect = percIsCorrect(input);
		}
		DiscountContainer.getInstance().create(new Discount(input));
	}
	
	private boolean percIsCorrect(int percentage) {
		final int MAX_PERCENTAGE = 20;
		
		if ((percentage > 0) && (percentage <= MAX_PERCENTAGE)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Discount getObj() {
		return DiscountContainer.getInstance().searchForObj(askForID());
	}

	public void deleteObj() {
		Discount discount = getObj();
		
		if (discount!= null) {
			DiscountContainer.getInstance().delete(discount);
			printSuccess();
		}
	}
	
	public int askForID() {
		if (DiscountContainer.getInstance().arraySize() > 0) {
			int input = keyboard.intInput();
			return input;
		}
		int input = -1;
		return input;
	}

	private void printNewOrderHeader() {
    	System.out.println("****** Create new discount******");
    	System.out.println("*****************************");	
	}
	
	private void printSuccess() {
		System.out.println("Discount created");
	}
	
	public void printAskPerc() {
		System.out.println("Enter discount in percentage: ");
	}
	
	public void printUnavailable() {
		System.out.println("This item is not available");
	}


}
