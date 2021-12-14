package controller;

import discountFolder.Discount;
import discountFolder.DiscountContainer;
import input.KeyboardInput;
import tui.PrintOuts;

public class DiscountController {
	
	private KeyboardInput keyboard;
	private PrintOuts po;
		
	public DiscountController() {
		keyboard = new KeyboardInput();
		po = new PrintOuts();
	}

	public void createObj() {
		boolean isCorrect = false;
		int input = 0;
		
		po.printNewOrderHeader();
		
		while (!isCorrect) {
			po.printAskPerc();
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
			po.printDeleted();
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
}