package model.PersonFolder;

import java.util.ArrayList;
import java.util.HashMap;

public class PersonContainer {

	// Declaration of Variables
	public HashMap<String, String> loginInfo = new HashMap<>();
	public ArrayList<Person> personsList = new ArrayList<>();
	public Person currentUser;
	private static PersonContainer instance;

	//Returns the Instance
	public static PersonContainer getInstance() {
		if (instance == null) {
			instance = new PersonContainer();
		}
		return instance;
	}
	
	public Person searchForObj(String username) {
		for (Person P : personsList) {
			if (P.getUsername().equals(username)) {
				return P;
			}
		}
		return null;
	}
	
	//CRUD Methods
		public void create(Person obj) {
			personsList.add(obj);
			loginInfo.put(obj.getUsername(), obj.getPassword());
			currentUser = obj;
		}
		
		public void readAll() {
			if (currentUser.getRole().equals("A")) {
				for (Person P : personsList) {
		            System.out.println("Username: " + P.getUsername());
					System.out.println("Password: " + P.getPassword());
					System.out.println("===============================");
					System.out.println();
				}
				
				System.out.println("Total number of users: " + personsList.size());
			
			} else if (currentUser.getRole().equals("E")) {
				for (Person P : personsList) {
		            System.out.println("Username: " + P.getUsername());
					System.out.println("===============================");
					System.out.println();
				}
				System.out.println("Total number of users: " + personsList.size());
			}
			
		}

		public void update(Person obj) {
			loginInfo.put(obj.getUsername(), obj.getPassword());
		}
		
		public void delete(Person obj) {
			loginInfo.remove(obj.getUsername(), obj.getPassword());
			personsList.remove(obj);
		}
}