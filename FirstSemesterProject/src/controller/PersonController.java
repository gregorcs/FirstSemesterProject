package controller;


import input.KeyboardInput;
import model.PersonFolder.*;
import tui.MainMenu;
import tui.UserSettingsMenu;

public class PersonController {
	private KeyboardInput keyboard;
	MainMenu mm;
	
	public PersonController() {
		keyboard = new KeyboardInput();
		mm = MainMenu.getInstance();
		mm.setIsLoggedIn(false);
	}
	
	public void createObj() {
		String username, password, password2, role;
		boolean correctUN = false;
		boolean correctPass = false;
		
		printCreateAccHeader();
		
		// checks4Dupes
		PersonContainer percon = PersonContainer.getInstance();
		username = ask4UN();
		while(!correctUN) {
			if (!percon.loginInfo.containsKey(username)) {
				correctUN = true;
			} else {
				printDupeError();
				username = ask4UN();
			}
		}
		
		password = ask4Pass();
		
		// double checks password input
		 printConfirm();
		 while (!correctPass) {
			 password2 = keyboard.stringInput();
			   if (password2.equals(password)) {
				   correctPass = true;
			   } else {
				   printTryAgain();
			   }
		}
	
		printSuccess();
		
		role = ask4Role();
		
		// Object Creation
		Person obj = new Person(username, password, role);
		percon.create(obj);
		mm.setIsLoggedIn(true);
	}
	
	public void updateUN() {
		PersonContainer percon = PersonContainer.getInstance();
		Person obj = verify();
		
		System.out.println("Enter new username: ");
		obj.setUsername(keyboard.stringInput());
		percon.update(obj);
	}
	
	public void updatePass() {
		PersonContainer percon = PersonContainer.getInstance();
		Person obj = verify();	
		
		System.out.println("Enter new password: ");
		obj.setPassword(keyboard.stringInput());
		percon.update(obj);
	}
	
	public void deleteObj() {
		Person obj = verify();
		if (obj != null) {
			PersonContainer.getInstance().delete(obj);
			printSuccessDelete();
		} else {
			print404Error();
		    UserSettingsMenu usm = new UserSettingsMenu();
		    usm.start();
		}
	}
	
	public void logIn() {
		PersonContainer percon = PersonContainer.getInstance();
		String username = "";
		String password;
		
		if (percon.personsList.size() == 0) {
			printMTError();
			mm.start();
		}
		
		while (!mm.getIsLoggedIn()) {
			
			// Asks 4 UN
			percon.currentUser = getObj();
			if (percon.currentUser == null) {
				print404Error();
			} else {
				username = percon.currentUser.getUsername();
	
			// Asks 4 Pass
			if (percon.loginInfo.containsKey(username)) {
				printAskPass();
				password = keyboard.stringInput();
				
				while (!password.equals(percon.loginInfo.get(username))) {
					printTryAgain();
					password = keyboard.stringInput();
					
					if (password.equals(percon.loginInfo.get(username))) {
					printLoginSuccessful();
					mm.setIsLoggedIn(true);
					}
				}
			}
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
	
	public String ask4Role() {
		boolean success = false;
		
		printAskRole();
		String temp = keyboard.stringInput();
		
		while (!success) {			
			switch (temp) {
			case "A":
				printSuccess();
				success = true;
				break;
			case "E":
				printSuccess();
				success = true;
				break;
			case "C":
				printSuccess();
				success = true;
				break;
			default:
					printTryAgain();
					temp = keyboard.stringInput();
					break;
				}
		}
			
		return temp;
	}
	
	public Person verify() {
		PersonContainer percon = PersonContainer.getInstance();
		Person obj = getObj();
		
		while (!percon.loginInfo.containsKey(obj.getUsername())) {
			printTryAgain();
			obj = getObj();
		}
		
		System.out.println("Currently managed account: " + obj.getUsername());
		return obj;
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
		System.out.println("Login successful!");
	}
	
	private void printAskUN() {
		System.out.println("Enter username: ");
	}
	private void printAskPass() {
		System.out.println("Enter password: ");
	}
	
	private void printAskRole() {
		System.out.println("Please press the key depicting the role you'd like to assign to this account:");
		System.out.println("(A) Admin");
		System.out.println("(E) Employee");
		System.out.println("(C) Customer");
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
		System.out.println("Invalid input detected. Please try again.");
	}
	
	public void printDupeError() {
		System.out.println("An account with this username already exists! Try a different one.");
	}
	
	public void print404Error() {
		System.out.println("No account found with this username!");
	}
	
	public void printMTError() {
		System.out.println("No accounts currently exist!");
	}
}