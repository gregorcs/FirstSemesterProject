package model;

import java.util.ArrayList;

import model.ProductFolder.ProductForLoan;

public class LoanProductContainer {
	
	//variable declarations
	private ArrayList<ProductForLoan> productsDatabase;
	private static LoanProductContainer instance;
	
	private LoanProductContainer() {
		productsDatabase = new ArrayList<ProductForLoan>();
	}
	
	//Returns instance
	public static LoanProductContainer getInstance() {
		if (instance == null) {
            instance = new LoanProductContainer();
		}
        return instance;
	}

	public ProductForLoan searchForObj(int ID) {
		for (ProductForLoan product : productsDatabase) {
			if (product.getID() == ID) {
				return product;				
			}
		}
		return null;						
	}
	
	//CRUD Methods

	public void create(ProductForLoan obj) {
		obj.setID(createID());
		productsDatabase.add(obj);
	}
	
	public void delete(ProductForLoan obj) {
		productsDatabase.remove(obj);
	}

	public void update(ProductForLoan obj) {
		productsDatabase.set(getID(obj), obj);
	}

	public int getID(ProductForLoan obj) {
		return productsDatabase.indexOf(obj);

	}
	
    public int createID() {
		int ID = productsDatabase.size();
		
		if(searchForObj(ID) == null) {				
			return ID;							
		} else {
			while (searchForObj(ID) != null) {		
				ID++;
			}
			return ID;
		}
	}

	//method for Junit
	public int arraySize() {
		return productsDatabase.size();
	}
	public ArrayList<ProductForLoan> getProductsDatabase() {
		return productsDatabase;
	}
}