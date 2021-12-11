package model.OrderFolder;

import input.KeyboardInput;

public abstract class Order {

	//Variable declarations
	private int orderID;
	private int customerID;
	private KeyboardInput keyboard;
	
	public Order(int ID, int customerID) {
	}
	
	//Getters & setters
	public int getID() {
		return orderID;
	}
	public void setID (int orderID) {
		this.orderID = orderID;
	}

	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID() {
		customerID = keyboard.intInput();
	}
}
