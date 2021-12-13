package model.PersonFolder;

import discountFolder.DiscountContainer;

public class CustomerContainer {

	public static CustomerContainer getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer searchForObj(String username) {
		return null;
		
	}
	
	public boolean customerExists(String customerName) {
		Customer p = CustomerContainer.getInstance().searchForObj(customerName);
		
		if (p != null) {
			return true;
		} else {
			return false;
		}
	}
}
