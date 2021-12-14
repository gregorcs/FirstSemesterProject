package controller;

import java.util.ArrayList;

import discountFolder.Discount;
import discountFolder.DiscountContainer;
import input.KeyboardInput;
import model.OrderFolder.OrderContainer;
import model.PersonFolder.Customer;
import model.PersonFolder.CustomerContainer;
import model.PersonFolder.Person;
import model.PersonFolder.PersonContainer;
import tui.ProductForSale;
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
		boolean isCorrect = false;
		String customerName = null;
		ItemOrder iOrder;
		Basket basket;
		
		printNewOrderHeader();
		
	/*	while(!isCorrect) {
			printAskCustName();
			customerName = keyboard.stringInput();
			isCorrect = CustomerContainer.getInstance().customerExists(customerName);
		}	*/			
		
		basket = new Basket(addToBasket(), addDiscounts());
		
		if (basket.getTotalPrice() > 0.00) {
			printAddItems();
			iOrder = new ItemOrder(customerName, basket);
			OrderContainer.getInstance().create(iOrder);
		} else {
			printEmptyOrder();
		}
	}

	private ArrayList<Discount> addDiscounts() {
		DiscountController dController = new DiscountController();
		ArrayList<Discount> discountAL = new ArrayList<Discount>();
		Discount discount= null;
		boolean isCorrect = true;
		int input = 0;
		
		while (input != -1 && isCorrect) {									//asks if you want to add another discount
			System.out.println("Enter discount ID: ");
			if (DiscountContainer.getInstance().arraySize() != 0) {
				discount = dController.getObj();
				if (!dController.discountExists(discount)) {
					isCorrect = false;
				} else {
					discountAL.add(discount);
				}
				printAskCont();											//if you enter wrong discount index it goes through
			} else {													
				printUnavDiscount();
				return discountAL;										
			}
			input = keyboard.intInput();
			}	
		return discountAL;
	}
	
	//this should be in customerController

	
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
	//this should be in discount classes, but have no time 
	public void printUnavDiscount() {
		System.out.println("No discounts available");
	}
	
	public void printEmptyOrder() {
		System.out.println("You created an empty order.");
	}

}
