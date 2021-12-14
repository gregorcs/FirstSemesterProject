package controller;

import java.util.ArrayList;

import discountFolder.Discount;
import discountFolder.DiscountContainer;
import input.KeyboardInput;
import model.OrderFolder.OrderContainer;
import model.ProductFolder.ProductForSale;
import tui.OrderTui;
import tui.PrintOuts;
import model.LineItem;
import model.CustomerFolder.Customer;
import model.CustomerFolder.CustomerContainer;
import model.OrderFolder.Basket;
import model.OrderFolder.ItemOrder;

public class OrderController {
	
	private KeyboardInput keyboard;
	private ProductController pController;
	private PrintOuts po;
		
	public OrderController() {
		keyboard = new KeyboardInput();
		pController = new ProductController();
		po = new PrintOuts();
	}

	public void createObj() {
		String customerName = null;
		ItemOrder iOrder;
		boolean isCorrect = false;
		Basket basket;
		
		po.printNewOrderHeader();
		
		while (!isCorrect) {
			po.printAskCustName();
			customerName = keyboard.stringInput();
			isCorrect = customerExists(customerName);
		}				
		
		basket = new Basket(addToBasket(), addDiscounts());

		iOrder = new ItemOrder(customerName, basket);
		OrderContainer.getInstance().create(iOrder);
		
		OrderTui oTui = new OrderTui();
		oTui.printOrderInformation(iOrder);
	}

	private ArrayList<Discount> addDiscounts() {
		DiscountController dController = new DiscountController();
		ArrayList<Discount> discountAL = new ArrayList<Discount>();
		Discount discount= null;
		boolean isCorrect = true;
		int input = 0;
		
		while (input != -1 && isCorrect) {									//asks if you want to add another discount															//checks if discount exists

			System.out.println("Enter discount ID: ");
			if (DiscountContainer.getInstance().arraySize() != 0) {
				discount = dController.getObj();
				if (discount == null) {
					isCorrect = false;
				} else {
					discountAL.add(discount);
				}

				po.printAskCont();											
			} else {													
				po.printUnavDiscount();
				return discountAL;										
			}
			input = keyboard.intInput();
			}	
		return discountAL;
	}
	
	public boolean customerExists(String customerName) {
		Customer p = CustomerContainer.getInstance().searchForObj(customerName);
		if (p != null) {
			return true;
		} else {
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
			po.printSuccess();
		}
	}
	
	public int askForID() {
		if (OrderContainer.getInstance().arraySize() > 0) {
			po.printAskforID();
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
			po.printAskQty();
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
}