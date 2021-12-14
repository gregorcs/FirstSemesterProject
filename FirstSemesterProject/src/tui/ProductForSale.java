package tui;

import model.ProductFolder.Product;

public class ProductForSale extends Product {
	
	//variable declarations
	private int minimumAmount;
	private int maximumAmount;

	//constructor for Product and this class
	public ProductForSale(int stock, String name, String location, double price, boolean available, int minimumAmount, int maximumAmount) {
		super(stock, name, location, price, available);

		this.minimumAmount = minimumAmount;
		this.maximumAmount = maximumAmount;
	}
	
	public void DecrementStock(int qty) {
		if ((stock - qty) >= minimumAmount) {
			stock -= qty;
		}
	}
	
	public boolean canDecrementStock(int qty) {
		if ((qty > 0) && ((stock - qty) >= minimumAmount) && (qty <= stock)) {
			return true;
		} else {
			qtyIsZero();
			return false;
		}
	}

	//TODO 
	//make so you cannot increm by 0
	public boolean canIncrementStock(int qty) {
		if ((stock + qty) < maximumAmount) {
			return true;
		} else {
			return false;
		}
	}
	
	//getters and setters
	public int getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(int minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public int getMaximumAmount() {
		return maximumAmount;
	}

	public void setMaximumAmount(int maximumAmount) {
		this.maximumAmount = maximumAmount;
	}
	private void qtyIsZero() {
		System.out.println("Insufficient stock.");
	}
}
