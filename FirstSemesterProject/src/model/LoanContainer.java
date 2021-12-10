package model;

import java.util.ArrayList;

public class LoanContainer {
	
	//variable declarations
	private ArrayList<Loan> productsDatabase;
	private static LoanContainer instance;
	
	protected LoanContainer() {
		productsDatabase = new ArrayList<Loan>();
	}
	
	//Returns instance
	public static LoanContainer getInstance() {
		if (instance == null) {
            instance = new LoanContainer();
		}
        return instance;
	}

	public Loan searchForObj(int ID) {
		for (Loan product : productsDatabase) {
			if (product.getID() == ID) {
				return product;				
			}
		}
		return null;						
	}
	
	//CRUD Methods

	public void create(Loan obj) {
		obj.setID(createID());
		productsDatabase.add(obj);
	}
	
	public void delete(Loan obj) {
		productsDatabase.remove(obj);
	}

	public void update(Loan obj) {
		productsDatabase.set(getID(obj), obj);
	}

	public int getID(Loan obj) {
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

	public int arraySize() {
		return productsDatabase.size();
	}
	public ArrayList<Loan> getProductsDatabase() {
		return productsDatabase;
	}
}
