package model.ProductFolder;

import java.util.ArrayList;

import model.ContainerInterface;

public class ProductContainer implements ContainerInterface<Product> {
	
	//variable declarations, 
	private ArrayList<ArrayList<Product>> categoriesDatabase;
	private ArrayList<Product> productsdatabase;
	private static ProductContainer instance;
	
	//constructor
	private ProductContainer() {
		categoriesDatabase = new ArrayList<ArrayList<Product>>();
	}
	
	//Returns instance
	public static ProductContainer getInstance() {
		if (instance == null) {
            instance = new ProductContainer();
		}

        return instance;
	}

	//CRUD Methods
	@Override
	public Product searchForObj() {
		//Searches for the specific item, not for category
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Product read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getArray() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
