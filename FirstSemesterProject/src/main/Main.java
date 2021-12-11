package main;

import java.util.ArrayList;

import loanFolder.Loan;
import loanFolder.LoanContainer;
import loanFolder.LoanProductContainer;
import model.PersonFolder.Person;
import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForLoan;
import model.ProductFolder.ProductForSale;
import tui.MainMenu;

public class Main {
	
	public static void main (String args[]) {
		//testCreateProducts();
		//testCreateLoans();
		MainMenu mainMenu = new MainMenu();
		mainMenu.start();
		
	}
	
	static void testCreateProducts() {
		for (int i = 0; i < 4; i++) {
			ProductContainer.getInstance().create(new ProductForSale(5, "hammer", null, 2, true, 4, 5, "woodworking"));
		}
		System.out.println("Products initialized: " + ProductContainer.getInstance().arraySize());
	}
	static void testCreateLoans() {
		ProductForLoan PFL = new ProductForLoan(5, "drill", "diy", 5.23, true);
		LoanProductContainer.getInstance().create(PFL);
		ArrayList<ProductForLoan> al = new ArrayList<ProductForLoan>();
		
		for (int i = 0; i < 4; i++) {
			LoanProductContainer.getInstance().create(PFL);
			al.add(LoanProductContainer.getInstance().searchForObj(i));
			LoanContainer.getInstance().create(new Loan(new Person("gregor", "abc"), al, 6));
		}
		System.out.println("Loans initialized: " + ProductContainer.getInstance().arraySize());
	}
	
}
