package model.PersonFolder;

public class Person {

	// Declaration of Variables
	private String username, password;
	
	// Constructor for Person
	public Person(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// Setters n' Getters
	public void setUsername(String username) {
		this.username = username;
	}
		
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
}