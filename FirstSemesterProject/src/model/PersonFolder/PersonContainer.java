package model.PersonFolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class PersonContainer {

	// Declaration of Variables
	public HashMap<String, String> personsDatabase = new HashMap<>();
	public ArrayList<Person> personsList = new ArrayList<>();
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
			if (P.getUsername() == username) {
				return P;
			}
		}
		return null;
	}
	
	//CRUD Methods
		public void create(Person obj) {
			personsList.add(obj);
			personsDatabase.put(obj.getUsername(), obj.getPassword());
		}
		
		public void readAll() {
			for (Entry<String, String> e : personsDatabase.entrySet()) {
	            System.out.println("Username: " + e.getKey());
			// For Testing Purposes ONLY
				System.out.println("Password: " + e.getValue());
				System.out.println();
			}
			
			System.out.println("Total number of users: " + personsDatabase.size());
		}

		public void update(Person obj) {
			personsDatabase.put(obj.getUsername(), obj.getPassword());
		}
		
		public void delete(Person obj) {
			personsDatabase.remove(obj.getUsername(), obj.getPassword());
		}
}