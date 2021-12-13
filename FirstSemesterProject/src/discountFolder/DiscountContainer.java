package discountFolder;

import java.util.ArrayList;

public class DiscountContainer {
	
	//variable declarations
	private ArrayList<Discount> discountDatabase;
	private static DiscountContainer instance;
	
	//constructor
	private DiscountContainer() {
		discountDatabase = new ArrayList<Discount>();
	}
	
	//Returns instance
	public static DiscountContainer getInstance() {
		if (instance == null) {
            instance = new DiscountContainer();
		}
        return instance;
	}

	public Discount searchForObj(int ID) {
		for (Discount discount : discountDatabase) {
			if (discount.getID() == ID) {
				return discount;
			}
		}
		return null;
	}
	
	//CRUD Methods
	public void create(Discount obj) {
		obj.setID(createID());
		discountDatabase.add(obj);
	}
	
	public void delete(Discount obj) {
		discountDatabase.remove(obj);
	}

	public void update(Discount obj) {
		discountDatabase.set(getID(obj), obj);
	}

	public int getID(Discount obj) {
		return discountDatabase.indexOf(obj);

	}
	
	public int createID() {
		int ID = discountDatabase.size();
		
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
		return discountDatabase.size();
	}
	public ArrayList<Discount> getDiscountDatabase() {
		return discountDatabase;
	}
}
