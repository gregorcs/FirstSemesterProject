package model.PersonFolder;

public class Person {

	// Declaration of Variables
	private String username, password, role;
	
	// Constructor for Person
	public Person(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
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
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		if(role!=null)
		return role;
		else return null;
	}
}