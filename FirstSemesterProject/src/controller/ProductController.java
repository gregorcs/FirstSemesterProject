package controller;

import input.KeyboardInput;
import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;
import tui.ProductTui;

public class ProductController implements InterfaceController<ProductForSale> {

	private KeyboardInput keyboard;
	private ProductTui prodTui;
	
	public ProductController() {
		keyboard = new KeyboardInput();
	}
	
	@Override
	public void createObj() {
    	int  amount, minAmount, maxAmount;
    	String name, location;
    	double price;
    	boolean isAvailable = false;
    	ProductForSale pForSale;
    	prodTui = new ProductTui();
    	
    	prodTui.printCreateProdHeader();
		System.out.println("Enter the name of the product for sale: ");
		name = keyboard.stringInput();
		System.out.println("Enter the amount: ");
		amount = keyboard.intInput();
		System.out.println("Enter the price: ");
		price = keyboard.doubleInput();
		System.out.println("Enter minimum stock amount: ");
		minAmount = keyboard.intInput();
		System.out.println("Enter maximum stock amount: ");
		maxAmount = keyboard.intInput();
		System.out.println("Enter location of product: ");
		location = keyboard.stringInput();
		
		isAvailable = (amount > 0) ? false : true;
		
		//create object
		pForSale = new ProductForSale(amount, name, location, price, isAvailable, minAmount, maxAmount);
		ProductContainer.getInstance().create(pForSale);
	}
	
	@Override
	public ProductForSale getObj() {
		return ProductContainer.getInstance().searchForObj(askForID());
	}

	@Override
	public void updateObj() {
		
	}

	@Override
	public void deleteObj() {
		ProductForSale product = getObj();
		prodTui = new ProductTui();
		
		if (product != null) {
			ProductContainer.getInstance().delete(product);
			prodTui.printSuccess();
		}
		else {
			prodTui.printUnavailable();
		}
	}
	
	public int askForID() {
		prodTui = new ProductTui();
		
		if (ProductContainer.getInstance().arraySize() > 0) {
			prodTui.printAskforID();
			int input = keyboard.intInput();
			return input;
		}
		int input = -1;
		return input;
	}
}
