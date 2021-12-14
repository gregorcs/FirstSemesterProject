package model.OrderFolder;

import java.util.ArrayList;

public class OrderContainer {

	private ArrayList<ItemOrder> orderDatabase;
	private static OrderContainer instance;

	private OrderContainer() {
		orderDatabase = new ArrayList<ItemOrder>();
	}
	
	public static OrderContainer getInstance() {
		if (instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	
	public ItemOrder searchForObj(int ID) {
		for (ItemOrder order : orderDatabase) {
			if(order.getID()==ID) {
				return order;
			}
		}
		return null;
	}
	
	//CRUD Methods
	public void create (ItemOrder obj) {
		obj.setID(createID());
		orderDatabase.add(obj);
	}
	
	public void delete (ItemOrder obj) {
		orderDatabase.remove(obj);
	}
	
	public void update(ItemOrder obj) {
		orderDatabase.set(getID(obj), obj);
	}
	
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