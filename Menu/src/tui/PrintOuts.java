package tui;

import model.PersonFolder.PersonContainer;

public class PrintOuts {
	PersonContainer percon = PersonContainer.getInstance();
	
	// Main Menu
	public void printIntro() {
		System.out.println("****** Shopping in Vestbjerg Byggecenter ******");
	}
	
	public void printMainMenu() {
		System.out.println("****** Main Menu ******");
		System.out.println(" (1) Register");
	    System.out.println(" (2) Log In");
	    System.out.println(" (0) Quit the program");
	    System.out.print("\n Choice:");
	}
	
	public void printAdminMenu() {
		System.out.println("****** Admin Menu ******");
		System.out.println(" (1) Create Order");
		System.out.println(" (2) Edit Customers");
		System.out.println(" (3) Product Menu");
		System.out.println(" (4) Discounts");
		System.out.println(" (5) User Settings");
		System.out.println(" (0) Log Out");
		System.out.print("\n Choice:");
	}

	public void printEmployeeMenu() {
		System.out.println("****** Employee Menu ******");
		System.out.println(" (1) Create Order");
		System.out.println(" (2) Product Menu");
		System.out.println(" (3) Discounts");
		System.out.println(" (4) User Settings");
		System.out.println(" (0) Log Out");
	}
		
	public void printGoodbye() {
		System.out.println("Thank you for shopping with us!");
	}
	
	public void printCreateAccHeader() {
    	System.out.println("**********Create an Account*********");
    	System.out.println("************************************");
	}
	
	// User Settings Menu	
	public void printUSM(String role) {
			if (role.equals("A")) {
				System.out.println("****** User Settings Menu ******");
			    System.out.println(" (1) Change Username of Current Account");
			    System.out.println(" (2) Change Password of Current Account");
			    System.out.println(" (3) Show All Existing Accounts");
			    System.out.println(" (0) Return");
			    System.out.print("\n Choice:");
			    
			} else if (role.equals("E")) {
				System.out.println("****** User Settings Menu ******");
			    System.out.println(" (1) Change Password of Current Account");
			    System.out.println(" (2) Show All Existing Accounts");
			    System.out.println(" (0) Return");
			    System.out.print("\n Choice:");
			}
		}
	
	// Account Management Menu
	public void printAMM() {
		System.out.println("****** Account Management Menu ******");
		System.out.println(" (1) Change Username of Selected Account");
	    System.out.println(" (2) Change Password of Selected Account");
	    System.out.println(" (3) Delete Selected Account");
	    System.out.println(" (0) Return");
	    System.out.print("\n Choice:");
	}
	
	// Input Prompts
	public void printAskUN() {
		System.out.println("Enter username: ");
	}
	
	public void printAskPass() {
		System.out.println("Enter password: ");
	}
	
	public void printAskRole() {
		System.out.println("Please press the key depicting the role you'd like to assign to this account:");
		System.out.println("(A) Admin");
		System.out.println("(E) Employee");
	}
	
	// Input Reactions
	public void errorMessage() {
		System.out.println("Invalid input, try again: ");
	}	
	
	public void printLoginSuccessful() {
		System.out.println("Login successful!");
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
	
	public void printRoleError() {
		System.out.println("Your role is 'null' or unknown, contact admin!");
	}
}