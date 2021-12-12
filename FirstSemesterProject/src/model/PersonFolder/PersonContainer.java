package model.PersonFolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import controller.PersonController;

public class PersonContainer {

	// Declaration of Variables
	public HashMap<String, String> loginInfo = new HashMap<>();
	public ArrayList<Person> personsList = new ArrayList<>();
	private static PersonContainer instance;
	private String username;

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
		}
		
		public void readAll() {
			PersonController percontrol = new PersonController();
			Person obj = percontrol.getObj();
			if (obj.getRole().equals("a")) {
				for (Entry<String, String> e : loginInfo.entrySet()) {
		            System.out.println("Username: " + e.getKey());
					System.out.println("Password: " + e.getValue());
					System.out.println();
				}
				
				System.out.println("Total number of users: " + loginInfo.size());
			
			} else if (obj.getRole().equals("e")) {
				for (Entry<String, String> e : loginInfo.entrySet()) {
		            System.out.println("Username: " + e.getKey());
					System.out.println();
				}
				
				System.out.println("Total number of users: " + loginInfo.size());
			}
			
		}

		public void update(Person obj) {
			loginInfo.put(obj.getUsername(), obj.getPassword());
		}
		
		public void delete(Person obj) {
			loginInfo.remove(obj.getUsername(), obj.getPassword());
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getUsername() {
			if(username == null) return "null";
			else return this.username;
		}
}