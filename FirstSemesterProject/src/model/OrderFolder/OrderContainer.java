package model.OrderFolder;

import java.util.ArrayList;
import model.OrderFolder.Basket;
import model.ContainerInterface;
import model.LineItem;
import controller.ProductController;

public class OrderContainer implements ContainerInterface<ItemOrder> {

	//variable declarations
	private ArrayList<ItemOrder> orderDatabase;
	private static OrderContainer instance;
	private ProductController pController;
	
	//constructor
	private OrderContainer() {
		orderDatabase = new ArrayList<ItemOrder>();
	}
	
	
	//
	public static OrderContainer getInstance() {
		if (instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	
	@Override
	public ItemOrder searchForObj(int ID) {
		for (ItemOrder order : orderDatabase) {
			if(order.getID()==ID) {
				return order;
			}
		}
		return null;
	}
	
	//CRUD Methods
	@Override
	public void create (ItemOrder obj) {
		obj.setID(createID());
		orderDatabase.add(obj);
	}
	
	@Override
	public void delete (ItemOrder obj) {
		orderDatabase.remove(obj);
	}
	
	@Override
	public void update(ItemOrder obj) {
		orderDatabase.set(getID(obj), obj);
	}
	
	@Override
	public int getID(ItemOrder obj) {
		return orderDatabase.indexOf(obj);
	}
	
	public int createID() {
		int ID = orderDatabase.size();
		
		if (searchForObj(ID) == null) {
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
		return orderDatabase.size();
	}
	public ArrayList<ItemOrder> getOrderDatabase(){
		return orderDatabase;
	}
}


