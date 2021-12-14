package main;

import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;
import tui.MainMenu;
import tui.ProductTui;	

public class Main {
	
	public static void main (String args[]) {
		testCreateObj();							//test method, initialises and prints out 40 objects to start with
		MainMenu mainMenu = MainMenu.getInstance();
		mainMenu.start();
		
	}
	
	static void testCreateObj() {
		for (int i = 0; i < 40; i++) {
			ProductContainer.getInstance().create(new ProductForSale(30, "hammer", null, 5, true, 4, 50, "diy"));
		}
		ProductTui prodTui = new ProductTui();
		prodTui.printAllProductsForSale();
	}
	
}
