package model.ProductFolder;

public class ProductForSale extends Product {
	
	//variable declarations
	private int minimumAmount;
	private int maximumAmount;

	//constructor for Product and this class
	public ProductForSale(int amount, String name, String location, double price, boolean available, int minimumAmount, int maximumAmount) {
		super(amount, name, location, price, available);

		this.minimumAmount = minimumAmount;
		this.maximumAmount = maximumAmount;
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
