package controller;


import input.KeyboardInput;
import model.PersonFolder.*;
import tui.MainMenu;
import tui.PrintOuts;

public class PersonController {
	private KeyboardInput keyboard;
	MainMenu mm;
	PrintOuts po = new PrintOuts();
	
	public PersonController() {
		keyboard = new KeyboardInput();
		mm = MainMenu.getInstance();
	}
	
	public void createObj() {
		String username, password, password2, role;
		boolean correctUN = false;
		boolean correctPass = false;
		
		po.printCreateAccHeader();
		
		// checks4Dupes
		PersonContainer percon = PersonContainer.getInstance();
		username = ask4UN();
		while(!correctUN) {
			if (!percon.loginInfo.containsKey(username)) {
				correctUN = true;
			} else {
				po.printDupeError();
				username = ask4UN();
			}
		}
		
		password = ask4Pass();
		
		 po.printConfirmPassword();
		 while (!correctPass) {
			 password2 = keyboard.stringInput();
			   if (password2.equals(password)) {
				   correctPass = true;
			   } else {
				   po.printTryAgain();
			   }
		}
	
		po.printSuccess();
		
		role = ask4Role();
		
		Person obj = new Person(username, password, role);
		percon.create(obj);
		percon.setIsLoggedIn(true);
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
		String password, password2;
		boolean correctPass = false;
		
		System.out.println("Enter new password: ");
		password = keyboard.stringInput();
	
		po.printConfirmPassword();
		while (!correctPass) {
			password2 = keyboard.stringInput();
			if (password2.equals(password)) {
				correctPass = true;
			} else {
				po.printTryAgain();
			}
		 }
		po.printSuccess();
		obj.setPassword(password);
		percon.update(obj);
	}
	
	public void deleteObj() {
		Person obj = verify();
		if (obj != null) {
			PersonContainer.getInstance().delete(obj);
			po.printSuccessDelete();
		} else {
			po.print404Error();
		}
	}
	
	public void logIn() {
		PersonContainer percon = PersonContainer.getInstance();
		String username = "";
		String password;
		boolean stop = false;
		
		if (percon.getPersonsList().size() == 0) {
			po.printMTError();
			mm.start();
		}
		
		while (!stop) {
			
			// Asks 4 UN
			percon.setCurrentUser(getObj());
			if (percon.getCurrentUser() == null) {
				po.print404Error();
			} else {
				username = percon.getCurrentUser().getUsername();
	
			// Asks 4 Pass
			if (percon.loginInfo.containsKey(username)) {
				po.printAskPass();
				password = keyboard.stringInput();
				
				while (!password.equals(percon.loginInfo.get(username))) {
					po.printTryAgain();
					password = keyboard.stringInput();
				}
				po.printLoginSuccessful();
				percon.setIsLoggedIn(true);
				stop = true;
				}
			}
		}
	}
	
	public String ask4UN() {
		po.printAskUN();
		String temp = keyboard.stringInput();
		return temp;
	}
	
	public String ask4Pass() {
		po.printAskPass();
		String temp = keyboard.stringInput();
		return temp;
	}
	
	public String ask4Role() {
		boolean success = false;
		
		po.printAskRole();
		String temp = keyboard.stringInput();
		
		while (!success) {			
			switch (temp) {
			case "A":
				po.printSuccess();
				success = true;
				break;
			case "E":
				po.printSuccess();
				success = true;
				break;
			default:
					po.printTryAgain();
					temp = keyboard.stringInput();
					break;
			}
		}
			
		return temp;
	}
	
	public Person verify() {
		PersonContainer percon = PersonContainer.getInstance();
		Person currentUser = percon.getCurrentUser();
		po.printAskPass();
		String password = keyboard.stringInput();
		
		while (!password.equals(percon.loginInfo.get(currentUser.getUsername()))) {
			po.printTryAgain();
			po.printAskPass();
			password = keyboard.stringInput();
		}
		
		System.out.println("Currently managed account: " + currentUser.getUsername());
		return currentUser;
	}
	
	public Person getObj() {
		return PersonContainer.getInstance().searchForObj(ask4UN());
	}
}