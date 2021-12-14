package model.ProductFolder;

import java.util.ArrayList;

import tui.ProductForSale;

public class ProductContainer {
	
	//variable declarations
	private ArrayList<ProductForSale> productsDatabase;
	private static ProductContainer instance;
	
	//constructor
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

	public ProductForSale searchForObj(int ID) {
		for (ProductForSale product : productsDatabase) {
			if (product.getID() == ID) {
				return product;
			}
		}
		return null;
	}
	
	public ProductForSale searchForObj(ProductForSale PFS) {
		for (ProductForSale product : productsDatabase) {
			if (product.equals(PFS)) {
				return product;
			}
		}
		return null;
	}
	
	//CRUD Methods
	public void create(ProductForSale obj) {
		obj.setID(createID());
		productsDatabase.add(obj);
	}
	
	public void delete(ProductForSale obj) {
		productsDatabase.remove(obj);
	}

	public void update(ProductForSale obj) {
		productsDatabase.set(getID(obj), obj);
	}

	public int getID(ProductForSale obj) {
		return productsDatabase.indexOf(obj);
	}
	
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

	public int arraySize() {
		return productsDatabase.size();
	}
	public ArrayList<ProductForSale> getProductsDatabase() {
		return productsDatabase;
	}
}
