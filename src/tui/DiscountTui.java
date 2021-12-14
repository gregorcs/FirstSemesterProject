package tui;

import java.util.ArrayList;

import controller.DiscountController;
import discountFolder.Discount;
import discountFolder.DiscountContainer;
import input.KeyboardInput;

public class DiscountTui {
	private DiscountController dController;
	private KeyboardInput keyboard;
	private PrintOuts po;

	public DiscountTui() {
		dController = new DiscountController();
		keyboard = new KeyboardInput();
		po = new PrintOuts();
	}
	
	public void start() {
		boolean isRunning = true;
		int input;
		
		while(isRunning) {
			po.printDiscountMenu();
			input = keyboard.intInput();
			
			switch(input) {
				case 1:
					dController.createObj();
					break;
				case 2:
					printDiscount();
					break;
				case 3:
					printAllDiscounts();
					break;
				case 4:
					po.printAskIdToDel();
					dController.deleteObj();
					break;
				case 0:
					isRunning = false;
					break;
				default:
					break;
			}
		}
	}
	
	public void printDiscount() {
		po.printAskIdToFind();
		DiscountController dController = new DiscountController();
			Discount discount = dController.getObj();
			
		if (discount != null) {
			printProductInformation(discount);	
		} else {
			po.printUnavailable();
		}
	}
	
	public void printAllDiscounts() {
		for (Discount discount : DiscountContainer.getInstance().getDiscountDatabase()) {
			printProductInformation(discount);
		}
	}
	
	public void printRequestedDiscounts(ArrayList<Discount> al) {
		for (Discount discount : al) {
			printProductInformation(discount);
		}
	}
	
	public void printProductInformation(Discount discount) {
		System.out.println("------------------------------------");
		System.out.println("ID: " + discount.getID());
		System.out.println("Percentage: " + discount.getDiscPercentage() + "%");
		System.out.println("------------------------------------");		
	}
}