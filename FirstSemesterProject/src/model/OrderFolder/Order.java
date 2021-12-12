package model.OrderFolder;

import input.KeyboardInput;

public abstract class Order {

	//Variable declarations
	private int orderID;
	private String customerName;
	private KeyboardInput keyboard;
	private Basket basket;
	
	public Order(String customerName, Basket basket) {
		this.basket = basket;
		this.customerName = customerName;
	}
	
	//Getters & setters
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
	public Basket getBasket() {
		return basket;
	}
	
	public int getID() {
		return orderID;
	}
	public void setID (int orderID) {
		this.orderID = orderID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
