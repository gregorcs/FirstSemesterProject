package model.ProductFolder;

import java.util.ArrayList;

import discountFolder.Discount;

public abstract class Product {
	
	//Variable declarations
	private int ID;
	protected int stock;
	private String name;
	private String location;
	private double price;
	private boolean available;
	private ArrayList<Discount> discounts;

	
	public Product(int stock, String name, String location, double price, boolean available) {
		this.stock = stock;
		this.name = name;
		this.location = location;
		this.price = price;
		this.available = available;
	}
	
	//Getters and setters
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		this.ID = iD;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getAmount() {
		return stock;
	}
	
	public void setAmount(int amount) {
		this.stock = amount;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean availability) {
		this.available = availability;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(ArrayList<Discount> discounts) {
		this.discounts = discounts;
	}
}