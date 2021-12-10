package controller;

import input.KeyboardInput;
import model.PersonFolder.*;
import tui.MainMenu;

public class PersonController {
	private KeyboardInput keyboard;
	MainMenu mm;
	
	public PersonController() {
		keyboard = new KeyboardInput();
		mm = MainMenu.getInstance();
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
		mm.setIsLoggedIn(true);
		// Object Creation
		Person obj = new Person(username, password);
		percon.create(obj);
		percon.setUsername(username);
	}
	
	public void updateUN() {
		PersonContainer percon = PersonContainer.getInstance();
		
		Person obj = verify();
		percon.delete(obj);
		
		System.out.println("Enter new username: ");
		String username = keyboard.stringInput();
		obj.setUsername(username);
		percon.setUsername(username);
		percon.update(obj);
	}
	
	public void updatePass() {
		Person obj = verify();				
		System.out.println("Enter new password: ");
		obj.setPassword(keyboard.stringInput());
	
		PersonContainer.getInstance().update(obj);
	}
	
	public void deleteObj() {
		Person obj = verify();
		if (obj != null) {
			PersonContainer.getInstance().delete(obj);
			printSuccessDelete();
			mm.setIsLoggedIn(false);
		} else {
			print404Error();
		}
	}
	
	public void logIn() {
		PersonContainer percon = PersonContainer.getInstance();
		String username, password;
		boolean loggedIn = false;
		
		while(!loggedIn) {
			username = ask4UN();
			if(percon.personsDatabase.containsKey(username)) {
				printAskPass();
				password = keyboard.stringInput();
				while(!password.equals(percon.personsDatabase.get(username))) {
					printTryAgain();
					password = keyboard.stringInput(); ///There is no option in this to stop login in. Once you click login you stuck until you login.
				}
				printLoginSuccessful();
				mm.setIsLoggedIn(true);
				loggedIn = true;
				percon.setUsername(username);
			}
			else {
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
	
	public Person verify() {
		PersonContainer percon = PersonContainer.getInstance();
		boolean correct = false;
		
		String username = percon.getUsername();
		
		System.out.println("Logged in as: " + percon.getUsername());
		printConfirmPassword();
		String password = keyboard.stringInput();
		while(!correct) {
			if(password.equals(percon.personsDatabase.get(username))) {
				correct = true;
				printVerifySuccess();
			}
			else {
			printTryAgain();
			printAskPass();
			password = keyboard.stringInput();
			}
		}
		return percon.searchForObj(username);
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
	
	public void printVerifySuccess() {
		System.out.println("Password verified succesfully.");
	}
	
	public void printConfirmPassword() {
		System.out.println("Confirm your password: ");
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