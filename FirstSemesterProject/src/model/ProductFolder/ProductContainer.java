package model.ProductFolder;

import java.util.ArrayList;

import model.ContainerInterface;

public class ProductContainer implements ContainerInterface<ProductForSale> {
	
	//variable declarations
	private ArrayList<ProductForSale> productsDatabase;
	private static ProductContainer instance;
	
	private ProductContainer() {
		productsDatabase = new ArrayList<ProductForSale>();
	}
	
	//Returns instance
	public static ProductContainer getInstance() {
		if (instance == null) {
            instance = new ProductContainer();
		}
        return instance;
	}

	@Override
	public ProductForSale searchForObj(int ID) {
		for (ProductForSale product : productsDatabase) {
			if (product.getID() == ID) {
				return product;				
			}
		}
		return null;						
	}
	
	//CRUD Methods
	@Override
	public void create(ProductForSale obj) {
		obj.setID(createID());
		productsDatabase.add(obj);
	}
	
	@Override
	public void delete(ProductForSale obj) {
		productsDatabase.remove(obj);
	}

	@Override
	public void update(ProductForSale obj) {
		productsDatabase.set(getID(obj), obj);
	}

	@Override
	public int getID(ProductForSale obj) {
		return productsDatabase.indexOf(obj);

	}
	
    /**
    * First checks if the ID is already taken
    * Else it increments it and returns the next free one
    */
	public int createID() {
		int ID = productsDatabase.size();
		
		if(searchForObj(ID) == null) {				
			return ID;							
		}
		else {
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
	public ArrayList<ProductForSale> getProductsDatabase() {
		return productsDatabase;
	}
}
