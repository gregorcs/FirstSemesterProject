package controller;

import input.KeyboardInput;
import model.OrderFolder.OrderContainer;
import model.OrderFolder.Basket;
import model.OrderFolder.ItemOrder;
import java.util.ArrayList;


public class OrderController implements InterfaceController<ItemOrder>{
	
	private KeyboardInput keyboard;
	private ArrayList<Basket> orderItems; 
	
	public OrderController() {
		keyboard = new KeyboardInput();
	}

	//order creation
	@Override
	public void createObj() {
		int ID;
		int customerID;
		ItemOrder iOrder;
		Basket orderItems;
		
		printNewOrderHeader();
		printAskforID();
		ID = keyboard.intInput();
		printAskCustID();
		customerID = keyboard.intInput();
		printAddItems();
		
		
		iOrder = new ItemOrder(ID, customerID);
		OrderContainer.getInstance().create(iOrder);
	}

	private void printAddItems() {
		// TODO Auto-generated method stub
		
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
	
	private void printSuccess() {
		System.out.println("The order has been edited susccessfully!");
	}

	public void printUnavailable() {
		System.out.println("Unavailable order");
		
	}

}
