package controller;

import input.KeyboardInput;
import model.OrderFolder.OrderContainer;
import model.LineItem;
import model.OrderFolder.Basket;
import model.OrderFolder.ItemOrder;
import controller.ProductController;
import java.util.ArrayList;


public class OrderController implements InterfaceController<ItemOrder>{
	
	private KeyboardInput keyboard;
	private ProductController pController;
		
	public OrderController() {
		keyboard = new KeyboardInput();
		pController = new ProductController();
	}

	//order creation
	@Override
	public void createObj() {
		int ID;
		int customerID;
		ItemOrder iOrder;
		
		printNewOrderHeader();
		ID = OrderContainer.getInstance().createID();
		printAskCustID();
		customerID = keyboard.intInput();
		printAddItems();
		iOrder = new ItemOrder(ID, customerID, addToOrder());
		OrderContainer.getInstance().create(iOrder);
	
	}

	@Override
	public ItemOrder getObj() {
		return OrderContainer.getInstance().searchForObj(askForID());
	}

	//what we gonna do bout this
	@Override
	public void updateObj() {
		
	}

	@Override
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
		
		while (isRunning) {
			printAskQty();
			qty = keyboard.intInput();
			lineItem = new LineItem(pController.getObj(), qty);
			basket.addToBasket(lineItem);
			
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

	private void printAskCustID() {
		System.out.println("Please enter the ID of the customer: ");
		
	}
	//change text later
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
