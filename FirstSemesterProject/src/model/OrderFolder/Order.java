package model.OrderFolder;

import java.util.ArrayList;
import input.KeyboardInput;
import model.LineItem;

public abstract class Order {

	//Variable declarations
	private int orderID;
	private int customerID;
	private KeyboardInput keyboard;
	private Basket basket;
	
	public Order(int ID, int customerID, Basket basket) {
		this.basket = basket;
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

	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID() {
		customerID = keyboard.intInput();
	}
}
