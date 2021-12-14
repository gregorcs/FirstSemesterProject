package controller;

import input.KeyboardInput;
import model.OrderFolder.OrderContainer;
import model.CustomerFolder.Customer;
import model.CustomerFolder.CustomerContainer;
import model.ProductFolder.ProductForSale;
import model.LineItem;
import model.OrderFolder.Basket;
import model.OrderFolder.ItemOrder;

public class OrderController {

	private KeyboardInput keyboard;
	private ProductController pController;

	public OrderController() {
		keyboard = new KeyboardInput();
		pController = new ProductController();
	}

	//order creation
	public void createObj() {
		String customerName = null;
		ItemOrder iOrder;
		boolean isCorrect = false;

		printNewOrderHeader();

		while(!isCorrect) {
			printAskCustName();
			customerName = keyboard.stringInput();
			isCorrect = customerExists(customerName);
		}

		printAddItems();
		iOrder = new ItemOrder(customerName, addToOrder());
			OrderContainer.getInstance().create(iOrder);
	}

	public boolean customerExists(String customerName) {
		Person p = PersonContainer.getInstance().searchForObj(customerName);
		if ( (p != null) && (p.getRole().equals("C"))) {
			return true;
		}
		else {
			return false;
		}

	}

	public ItemOrder getObj() {
		return OrderContainer.getInstance().searchForObj(askForID());
	}

	public void deleteObj() {
		ItemOrder iOrder = getObj();

		if (iOrder != null) {
			OrderContainer.getInstance().delete(iOrder);
			printSuccess();
		}
	}

	public int askForID() {
		if (OrderContainer.getInstance().arraySize() > 0) {
			printAskforID();
			int input = keyboard.intInput();
			return input;
		}
		int input = -1;
		return input;
	}

	private Basket addToOrder() {
		boolean isRunning = true;
		int choice;
		int qty;
		Basket basket = new Basket();
		LineItem lineItem;
		ProductForSale PFS;

		while (isRunning) {
			PFS = pController.getObj();
			printAskQty();
			qty = keyboard.intInput();

			if (PFS.canDecrementStock(qty)) {
				lineItem = new LineItem(PFS, qty);
				basket.addToBasket(lineItem);
			} else {
				System.out.println("Sorry " + qty + " is not available.");
			}

			pController.printAskForProducts();
			choice = keyboard.intInput();
			if (choice == -1) {
				isRunning = false;
			}
		}
		return basket;
	}

	private void printNewOrderHeader() {
    	System.out.println("****** Create new order******");
    	System.out.println("*****************************");
	}

	private void printAskforID() {
		System.out.println("Please enter the ID of the order: ");
	}

	private void printAskCustName() {
		System.out.println("Please enter the name of the customer: ");

	}

	private void printAddItems() {
		System.out.println("****Add your items****");

	}

	public void printAskQty() {
		System.out.println("Enter desired quantity: ");
	}

	public void printAskID() {
		System.out.println("Enter the ID of the product to add: ");
	}

	private void printSuccess() {
		System.out.println("The order has been edited susccessfully!");
	}

	public void printUnavailable() {
		System.out.println("Unavailable order");

	}

}
