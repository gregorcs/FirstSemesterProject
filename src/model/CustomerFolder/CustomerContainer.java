package model.CustomerFolder;

import java.util.ArrayList;

public class CustomerContainer {
	public ArrayList<Customer> customersList = new ArrayList<>();
	
	private static CustomerContainer instance;

	//Returns the Instance
	public static CustomerContainer getInstance() {
		if (instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}
	
	//CRUD Methods
			public void create(Customer C) {
				customersList.add(C);
			}
			
			public void readAll() {
					for (Customer C : customersList) {
			            System.out.println("Name: " + C.getName());
			            System.out.println("Craftsman status: " + C.getHasCraft());
						System.out.println("===============================");
						System.out.println();
					}
					
					System.out.println("Total number of customers: " + customersList.size());		
			}
			
			public void delete(Customer C) {
				customersList.remove(C);
			}
			
			public Customer searchForObj(String name) {
				for (Customer C : customersList) {
					if (C.getName().equals(name)) {
						return C;
					}
				}
				return null;
			}
}