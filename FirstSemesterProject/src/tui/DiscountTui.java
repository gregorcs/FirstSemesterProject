package tui;

import controller.DiscountController;
import discountFolder.Discount;
import discountFolder.DiscountContainer;
import input.KeyboardInput;
import model.ProductFolder.ProductContainer;

public class DiscountTui {
	
	private DiscountController dController;
	private KeyboardInput kbInput;

	public DiscountTui() {
		dController = new DiscountController();
		kbInput = new KeyboardInput();
	}
	
	public void start() {
		boolean isRunning = true;
		int kbChoice;
		
		while(isRunning) {
			writeDiscountMenu();
			kbChoice = kbInput.intInput();
			
			switch(kbChoice) {
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
					break;
				case 5:
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
	
	private void writeDiscountMenu() {
		System.out.println("****** Manage Discounts ******");
        System.out.println(" (1) Create quantity discount");
        System.out.println(" (2) Create discount for customer");
        System.out.println(" (2) Print specific discount");
        System.out.println(" (3) Print all discounts");
        System.out.println(" (4) Update discount");
        System.out.println(" (5) Delete discount");
        System.out.println(" (0) Return to Main Menu");
        System.out.print("\n Choice:");
	}
	public void printDiscount() {	
		DiscountController dController = new DiscountController();
			Discount discount = dController.getObj();
			
		if (discount != null) {
			printProductInformation(discount);	
		}
		else {
			dController = new DiscountController();
			dController.printUnavailable();
		}
	}
	public void printAllDiscounts() {
		//what do we do with this?
		for (Discount discount : DiscountContainer.getInstance().getDiscountDatabase()) {
			printProductInformation(discount);
			System.out.println(ProductContainer.getInstance().arraySize());
		}
	}
	public void printProductInformation(Discount discount) {
		System.out.println("------------------------------------");
		System.out.println("ID: " + discount.getID());
		System.out.println("Percentage: " + discount.getDiscPercentage() + "%");
		System.out.println("------------------------------------");		
	}
	public void emptyDatabase() {
		System.out.println("Nothing to print");
	}
}
