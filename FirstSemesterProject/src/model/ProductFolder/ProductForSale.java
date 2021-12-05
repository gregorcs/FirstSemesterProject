package model.ProductFolder;

public class ProductForSale extends Product {
	
	//variable declarations
	private int minimumAmount;
	private int maximumAmount;

	//constructor for Product and this class
	public ProductForSale(int amount, String name, String location, double price, boolean available, int minimumAmount, int MaximumAmount, int maximumAmount) {
		super(amount, name, location, price, available);

		this.setMinimumAmount(minimumAmount);
		this.setMaximumAmount(maximumAmount);
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

}
