package tui;

import model.PersonFolder.PersonContainer;

public class PrintOuts {
	PersonContainer percon = PersonContainer.getInstance();

	// Main Menu
	public void printIntro() {
		System.out.println("****** Shopping in Vestbjerg Byggecenter ******");
	}

	public void printMainMenu() {
		if (!percon.getIsLoggedIn()) {
			System.out.println("****** Main Menu ******");
			System.out.println(" (1) Register");
		    System.out.println(" (2) Log In");
		    System.out.println(" (0) Quit the program");
		    System.out.print("\n Choice:");
		} else {
			String role = percon.getCurrentUser().getRole();

		if (role.equals("A")) {
			   System.out.println("****** Main Menu ******");
			   System.out.println(" (1) Create Order");
			   System.out.println(" (2) Account Management Menu");
			   System.out.println(" (3) Customer Management Menu");
			   System.out.println(" (4) Product Menu");
			   System.out.println(" (5) Discounts");
			   System.out.println(" (6) User Settings");
			   System.out.println(" (0) Log Out");
			   System.out.print("\n Choice:");

		} else if (role.equals("E")) {
			System.out.println("****** Main Menu ******");
			   System.out.println(" (1) Create Order");
			   System.out.println(" (2) Product Menu");
			   System.out.println(" (3) Discounts");
			   System.out.println(" (4) User Settings");
			   System.out.println(" (0) Log Out");
	    }
	  }
	}

	public void printAdminMenu() {
		System.out.println("****** Admin Menu ******");
		System.out.println(" (1) Create Order");
		System.out.println(" (2) Account Management Menu");
		System.out.println(" (3) Customer Management Menu");
		System.out.println(" (4) Product Menu");
		System.out.println(" (5) Discounts");
		System.out.println(" (6) User Settings");
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
	public void printUSM() {
			String role = percon.getCurrentUser().getRole();
			if (role.equals("A")) {
				System.out.println("****** User Settings Menu (Admin) ******");
			    System.out.println(" (1) Change Username of Current Account");
			    System.out.println(" (2) Change Password of Current Account");
			    System.out.println(" (3) Show All Existing Accounts");
			    System.out.println(" (0) Return");
			    System.out.print("\n Choice:");

			} else if (role.equals("E")) {
				System.out.println("****** User Settings Menu (Employee) ******");
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

	// Customer Management Menu
	public void printCMM() {
		System.out.println("****** Customer Management Menu ******");
		System.out.println(" (1) Create a New Customer");
	    System.out.println(" (2) Change Customer's Name");
	    System.out.println(" (3) Change Customer's Address");
	    System.out.println(" (4) Change Customer's Phone Number");
	    System.out.println(" (5) Delete Customer");
	    System.out.println(" (6) Show All Customers");
	    System.out.println(" (0) Return");
	    System.out.print("\n Choice:");
	}

	public void printCreateCusHeader() {
    	System.out.println("**********Create a Customer*********");
    	System.out.println("************************************");
	}

	// Discount Menu
	public void printDiscountMenu() {
		System.out.println("****** Manage Discounts ******");
        System.out.println(" (1) Create quantity discount");
        System.out.println(" (2) Print specific discount");
        System.out.println(" (3) Print all discounts");
        System.out.println(" (4) Delete discount");
        System.out.println(" (0) Return to Main Menu");
        System.out.print("\n Choice:");
	}
	
	// Input Prompts
	// Person
	public void printAskUN() {
		System.out.println("Enter username: ");
	}

	public void printAskPass() {
		System.out.println("Enter password: ");
	}
	
	public void printConfirmPassword() {
		System.out.println("Repeat your password: ");
	}

	public void printAskRole() {
		System.out.println("Please press the key depicting the role you'd like to assign to this account:");
		System.out.println("(A) Admin");
		System.out.println("(E) Employee");
	}

	// Customer
	public void printAskName() {
		System.out.println("Enter name: ");
	}

	public void printAskAddress() {
		System.out.println("Enter address: ");
	}

	public void printAskPhone() {
		System.out.println("Enter phone number: ");
	}

	public void printAskCraft() {
		System.out.println("Does this customer possess the craftsman status?");
		System.out.println("[Y] / [N]");
	}
	
	

	// Input Reactions
	// Success - Generic
	public void printSuccess() {
		System.out.println("Credentials set successfully.");
	}
	// Failure - Generic
	public void errorMessage() {
		System.out.println("Invalid input, try again: ");
	}
	
	public void printTryAgain() {
		System.out.println("Invalid input detected. Please try again.");
	}
	
	public void printDupeError() {
		System.out.println("An account with this username already exists! Try a different one.");
	}
	
	public void emptyDatabase() {
		System.out.println("Nothing to print");
	}
	// Person
	public void printLoginSuccessful() {
		System.out.println("Login successful!");
	}
	
	public void printSuccessDelete() {
		System.out.println("Account deleted successfully.");
	}
	
	public void printVerifySuccess() {
		System.out.println("Password verified succesfully.");
	}
	
	public void print404Error() {
		System.out.println("No account found with this username!");
	}
	
	public void printMTError() {
		System.out.println("No accounts currently exist!");
	}
	
	// Discount
	public void printNewDiscountHeader() {
    	System.out.println("****** Create new discount******");
    	System.out.println("*****************************");	
	}
	
	public void printAskIdToFind() {
		System.out.println("Enter the ID of the discount you're looking for: ");
	}
	
	public void printAskIdToDel() {
		System.out.println("Enter the ID of the discount you're looking to delete: ");
	}
	
	public void printDeleted() {
		System.out.println("Discount deleted");
	}
	
	public void printAskPerc() {
		System.out.println("Enter discount in percentage: ");
	}
	
	public void printUnavailableDiscount() {
		System.out.println("This discount is not available");
	}
	
	public void printUnavDiscount() {
		System.out.println("No discounts available");
	}
	
	// Order
	public void printNewOrderHeader() {
    	System.out.println("****** Create new order******");
    	System.out.println("*****************************");	
	}
	
	public void printOrderMenu() {
		System.out.println("****** Manage Orders ******");
        System.out.println(" (1) New order");
        System.out.println(" (2) Show specific order");
        System.out.println(" (3) Show all orders");
        System.out.println(" (4) Delete order");
        System.out.println(" (0) Return to Main Menu");
        System.out.print("\n Choice:");
	}
	
	public void printAskforID() {
		System.out.println("Please enter the ID of the order: ");
	}

	public void printAskCustName() {
		System.out.println("Please enter the name of the customer: ");	
	}
	
	public void printAskCont() {
		System.out.println("Any num to continue, -1 to exit: ");
	}
	
	public void printAskQty() {
		System.out.println("Enter desired quantity: ");
	}
	
	public void printAskID() {
		System.out.println("Enter the ID of the product to add: ");
	}
	
	public void printSuccessOrder() {
		System.out.println("The order has been edited susccessfully!");
	}

	public void printUnavailable() {
		System.out.println("Unavailable order");
	}
}