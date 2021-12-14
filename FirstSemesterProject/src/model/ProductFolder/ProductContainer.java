package model.ProductFolder;

import java.util.ArrayList;

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
	
	public boolean productExists(ProductForSale PFS) {
		if (PFS != null) {
			return true;
		} else {
			return false;
		}
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

	//method for Junit
	public int arraySize() {
		return productsDatabase.size();
	}
	public ArrayList<ProductForSale> getProductsDatabase() {
		return productsDatabase;
	}
	
	// I will make this a hashmap eventually TODO
	public ArrayList<ProductForSale> getCategory(String category) {
		ArrayList<ProductForSale> al = new ArrayList<ProductForSale>();
		
		for (ProductForSale productFS : productsDatabase) {
			if (productFS.getCategory().equals(category)) {
				al.add(productFS);
			}
		}
		return al;
	}
	
	
	
	
	
	
	
	
}
