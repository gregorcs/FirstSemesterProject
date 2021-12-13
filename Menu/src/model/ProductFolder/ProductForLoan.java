package model.ProductFolder;

public class ProductForLoan extends Product {
	
	//variable declarations
	private int daysRented; 
	
	//constructor for Product and this class
	public ProductForLoan(int amount, String name, String location, double price, boolean available, int daysRented) {
		super(amount, name, location, price, available);

		this.setDaysRented(daysRented);
	}

	//getters and setters
	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}

	
}
