package model;

import java.util.HashMap;

public class LoginContainer {
	Person person;
	HashMap<String, Person> loginInfo;
	private static LoginContainer instance;
	
	private LoginContainer() {
		person = new Person();
		loginInfo = new HashMap<String, Person>();
	}
	
	public static LoginContainer getInstance() {
		
		if(instance == null) {
			instance = new LoginContainer();
		}
		return instance;
	}
	
	public boolean checkUsername(String username) {
		if(loginInfo.containsKey(username)) {
			return true;
		}else return false;
	}
	
	public boolean checkPassword(String username, String password) {
		person = loginInfo.get(username);
		if(person.getPassword().equals(password)) { 
			return true;
		}else return false;
	}
	
	public void printEnterUsername() {
		System.out.println("Please enter your username: ");
	}
	
	public void printEnterPassword() {
		System.out.println("Please enter your password: ");
	}
	
	public void printLoggedIn() {
		System.out.println("You have logged in!");
	}
	
	public void printUsernameError() {
		System.out.println("Username doesn't exist");
	}
	
	public void printPasswordError() {
		System.out.println("The password doesn't match the account!");
	}
}
