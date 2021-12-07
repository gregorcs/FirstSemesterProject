package main;

import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;
import tui.MainMenu;
import tui.ProductTui;

public class Main {
	
	public static void main (String args[]) {
		testCreateObj();
		MainMenu mainMenu = new MainMenu();
		mainMenu.start();
	}
	
	static void testCreateObj() {
		for (int i = 0; i < 5; i++) {
			ProductContainer.getInstance().create(new ProductForSale(5, "hammer", null, 2, true, 4, 5));
		}
		ProductTui prodTui = new ProductTui();
		prodTui.printAllProductsForSale();
	}
	
}
