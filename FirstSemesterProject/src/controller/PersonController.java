package controller;

import java.util.ArrayList;
import java.util.Map.Entry;

import input.KeyboardInput;
import model.PersonFolder.*;
import tui.MainMenu;

public class PersonController {
	private KeyboardInput keyboard;
	
	public PersonController() {
		keyboard = new KeyboardInput();
	}
	
	public void createObj() {
		String username, password, password2;
		boolean correct = false;
		boolean correctUN = false;
		
		
		printCreateAccHeader();
		
		// checks4Dupes
		PersonContainer percon = PersonContainer.getInstance();
		username = ask4UN();
		while(!correctUN) {
			if(!percon.personsDatabase.containsKey(username)) {
				correctUN = true;
			}else {
				username = ask4UN();
			}
		}
		
		password = ask4Pass();
		
		// bugged but working on it if we got time
		 printConfirm();
		 while (!correct) {
			 password2 = keyboard.stringInput();
			   if (password2.equals(password)) {
				   correct = true;
			   } else {
				   printTryAgain();
			   }
		}
	
		printSuccess();
		
		// Object Creation
		Person obj = new Person(username, password);
		PersonContainer.getInstance().create(obj);
	}
	
	public void updateUN() {
		Person obj = getObj();	
		verify(obj);
		System.out.println("Enter new username: ");
		obj.setUsername(keyboard.stringInput());
	
		PersonContainer.getInstance().update(obj);
	}
	
	public void updatePass() {
		Person obj = getObj();		
		verify(obj);		
		System.out.println("Enter new password: ");
		obj.setPassword(keyboard.stringInput());
	
		PersonContainer.getInstance().update(obj);
	}
	
	public void deleteObj() {
		Person obj = getObj();
		
		if (obj != null) {
			PersonContainer.getInstance().delete(obj);
			printSuccessDelete();
		} else {
			print404Error();
		}
	}
	
	public void logIn() {
		PersonContainer percon = PersonContainer.getInstance();
		String username, password;
		boolean loggedIn = false;
		
		username = ask4UN();
		while(!loggedIn) {
			if(percon.personsDatabase.containsKey(username)) {
				printAskPass();
				password = keyboard.stringInput();
				while(!password.equals(percon.personsDatabase.get(username))) {
					printTryAgain();
					password = keyboard.stringInput();
				}
				printLoginSuccessful();
				loggedIn = true;
			}
			else {
				username = ask4UN();
				print404Error();
			}
		}
	}
	
	public String ask4UN() {
		printAskUN();
		String temp = keyboard.stringInput();
		return temp;
	}
	
	public String ask4Pass() {
		printAskPass();
		String temp = keyboard.stringInput();
		return temp;
	}
	
	public void verify(Person obj) {
		String username = obj.getUsername();
		PersonContainer percon = PersonContainer.getInstance();
		for (Entry<String, String> e : percon.personsDatabase.entrySet()) {
			while (username != e.getKey()) {
				print404Error();
				username = keyboard.stringInput();
			}
		}
		
		printAskPass();
		String password = keyboard.stringInput();
		while (obj.getPassword() != password) {
			printTryAgain();
			password = keyboard.stringInput();
		}
		
		printSuccess();
	}
	
	public Person getObj() {
		return PersonContainer.getInstance().searchForObj(ask4UN());
	}
	
	// Print Methods
	public void printCreateAccHeader() {
    	System.out.println("**********Create an Account*********");
    	System.out.println("************************************");
	}
	
	private void printLoginSuccessful() {
		System.out.println("Login succesful!");
	}
	
	private void printAskUN() {
		System.out.println("Enter username: ");
	}
	private void printAskPass() {
		System.out.println("Enter password: ");
	}
	
	public void printSuccess() {
		System.out.println("Credentials set successfully.");
	}
	
	public void printSuccessDelete() {
		System.out.println("Account deleted successfully.");
	}

	public void printConfirm() {
		System.out.println("Repeat your password: ");
	}
	
	public void printTryAgain() {
		System.out.println("The password is incorrect! Please try again.");
	}
	
	public void printDupeError() {
		System.out.println("An account with this username already exists! Try a different one.");
	}
	
	public void print404Error() {
		System.out.println("No account found with this username!");
	}
}