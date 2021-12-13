package controller;

import java.util.ArrayList;

import discountFolder.Discount;
import discountFolder.DiscountContainer;
import input.KeyboardInput;
import model.OrderFolder.OrderContainer;
import model.PersonFolder.Person;
import model.PersonFolder.PersonContainer;
import model.ProductFolder.ProductForSale;
import model.LineItem;
import model.OrderFolder.Basket;
import model.OrderFolder.ItemOrder;

public class OrderController {
	
	private KeyboardInput keyboard;
	private ProductController pController;
		
	public OrderController() {
		keyboard = new KeyboardInput();
		pController = new ProductController();
	}

	//order creation
	public void createObj() {
		String customerName = null;
		ItemOrder iOrder;
		boolean isCorrect = false;
		Basket basket;
		
		printNewOrderHeader();
		
		while(!isCorrect) {
			printAskCustName();
			customerName = keyboard.stringInput();
			isCorrect = customerExists(customerName);
		}				
		
		basket = new Basket(addToBasket(), addDiscounts());
		printAddItems();											
		iOrder = new ItemOrder(customerName, basket);
		OrderContainer.getInstance().create(iOrder);
		System.out.println(basket.getListOfDiscounts().get(0).getDiscPercentage());
	}

	private ArrayList<Discount> addDiscounts() {
		DiscountController dController = new DiscountController();
		ArrayList<Discount> discountAL = new ArrayList<Discount>();
		Discount discount= null;
		boolean isCorrect = false;
		int input = 0;
		
		while (input != -1) {									//asks if you want to add another discount
			while(discount == null) {							//checks if discount exists
			System.out.println("Enter discount ID: ");
			discount = dController.getObj();					//runs infinitely if discarray is empty
			}
			discountAL.add(discount);
			printAskCont();
			input = keyboard.intInput();
		}
		return discountAL;
	}
	
	
	public boolean customerExists(String customerName) {
		Person p = PersonContainer.getInstance().searchForObj(customerName);
		if ( (p != null) && (p.getRole().equals("C"))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ItemOrder getObj() {
		return OrderContainer.getInstance().searchForObj(askForID());
	}

	public void deleteObj() {
		ItemOrder iOrder = getObj();
		
		if (iOrder != null) {
			OrderContainer.getInstance().delete(iOrder);
			printSuccess();
		}
	}
	
	public int askForID() {
		if (OrderContainer.getInstance().arraySize() > 0) {
			printAskforID();
			int input = keyboard.intInput();
			return input;
		}
		int input = -1;
		return input;
	}
	
	private ArrayList<LineItem> addToBasket() {
		ArrayList<LineItem> al = new ArrayList<LineItem>();
		boolean isRunning = true;
		int choice;
		int qty;
		LineItem lineItem;
		ProductForSale PFS;
		
		while (isRunning) {
			PFS = pController.getObj();
			printAskQty();
			qty = keyboard.intInput();
			
			if (PFS.canDecrementStock(qty)) {
				lineItem = new LineItem(PFS, qty);
				al.add(lineItem);
			} else {
				System.out.println("Sorry " + qty + " is not available.");
			} 
			
			pController.printAskForProducts();
			choice = keyboard.intInput();
			if (choice == -1) {
				isRunning = false;
			}
		}
		return al;
	}

	private void printNewOrderHeader() {
    	System.out.println("****** Create new order******");
    	System.out.println("*****************************");	
	}
	
	private void printAskforID() {
		System.out.println("Please enter the ID of the order: ");
	}

	private void printAskCustName() {
		System.out.println("Please enter the name of the customer: ");	
	}
	
	private void printAskCont() {
		System.out.println("Any num to continue, -1 to exit: ");
	}
	
	private void printAddItems() {
		System.out.println("****Add discount****");	
	}
	
	public void printAskQty() {
		System.out.println("Enter desired quantity: ");
	}
	
	public void printAskID() {
		System.out.println("Enter the ID of the product to add: ");
	}
	
	private void printSuccess() {
		System.out.println("The order has been edited susccessfully!");
	}

	public void printUnavailable() {
		System.out.println("Unavailable order");
		
	}

}
