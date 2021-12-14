package model.ProductFolder;

public class ProductForSale extends Product {

	private int minimumAmount;
	private int maximumAmount;
	private String category;

	
	public ProductForSale(int stock, String name, String location, double price, boolean available, int minimumAmount, int maximumAmount, String category) {
		super(stock, name, location, price, available);

		this.minimumAmount = minimumAmount;
		this.maximumAmount = maximumAmount;
		this.setCategory(category);
	}
	
	public void DecrementStock(int qty) {
		if ((stock - qty) >= minimumAmount) {
			stock -= qty;
		}
	}
	
	public boolean canDecrementStock(int qty) {
		if ((qty > 0) && (stock - qty) >= minimumAmount) {
			return true;
		} else {
			qtyIsZero();
			return false;
		}
	}

	public boolean canIncrementStock(int qty) {
		if ((stock + qty) < maximumAmount) {
			return true;
		} else {
			return false;
		}
	}
	
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
		System.out.println("Quantity cannot be zero.");
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}