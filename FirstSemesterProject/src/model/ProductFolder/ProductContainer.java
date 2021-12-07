package model.ProductFolder;

import java.util.ArrayList;

import model.ContainerInterface;

public class ProductContainer implements ContainerInterface<Product> {
	
	//variable declarations
	private ArrayList<Product> productsDatabase;
	private static ProductContainer instance;
	
	//constructor
	private ProductContainer() {
		productsDatabase = new ArrayList<Product>();
	}
	
	//Returns instance
	public static ProductContainer getInstance() {
		if (instance == null) {
            instance = new ProductContainer();
		}

        return instance;
	}


	@Override
	public Product searchForObj(int ID) {
		//Searches for the specific item, not for category
		for (Product product : productsDatabase) {
			if (product.getID() == ID) {
				return product;
			}
		}

		return null;
	}
	//CRUD Methods
	@Override
	public void create(Product obj) {
		productsDatabase.add(obj);
	}
	
	@Override
	public Product read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Product obj) {
		productsDatabase.remove(obj);
		
	}

	@Override
	public void update(Product obj) {

		productsDatabase.set(getID(obj), obj);
	}

	@Override
	public int getID(Product obj) {
		productsDatabase.indexOf(obj);
		return 0;
	}

}
