package model.OrderFolder;

import java.util.ArrayList;
import java.util.ListIterator;
import model.LineItem;
import input.KeyboardInput;

public class Basket {
	private ArrayList<LineItem> itemsList;
	private double discount;
	private int customerID;
	private KeyboardInput keyboard;
	
	public Basket() {
		this.itemsList = new ArrayList<>();
		this.discount = 0;
	}
	
	//add an item to the basket
	public void addToBasket(LineItem item) {
		this.itemsList.add(item);
	}
	
	//show the basket
	public void showBasket() {
		ListIterator<LineItem> iterator = itemsList.listIterator();
		while(iterator.hasNext()) {
			LineItem item1 = iterator.next();
			System.out.println(item1);
		} 
	}
	
	//remove an item from basket
	public void removeFromBasket(LineItem i) {
		ListIterator<LineItem> iterator1 = itemsList.listIterator();
		while (iterator1.hasNext()) {
			LineItem item2 = iterator1.next();
			if (item2.getName().equals(i.getName())) {
				this.itemsList.remove(i);
				break;
			}
		}
	}
	
	//total price of all items
	public double getTotalPrice() {	
		double singleProdPrice;			//this is what one product costs
		double lineItemPrice = 0;		//this is the sum of one product * quantity
		double finalPrice = 0;			//Let's say someone ordered 2 diff products, both with quantity of ten: 2 * 10 = 20 * 5 euro = 100eur
		int qtyToBuy;
		
		for (int i = 0; i < itemsList.size(); i++) {
			lineItemPrice = 0;
			singleProdPrice = itemsList.get(i).getPrice();
			qtyToBuy = itemsList.get(i).getQty();
			
			lineItemPrice += (singleProdPrice * qtyToBuy);
			finalPrice += lineItemPrice;
		}
		return finalPrice;
	}
	
	//connect with Discount class & put customer IDs in groups. the ID will act like a discount code.
	//the discount amount will depend on the group the customer is in.
	private void applyDiscount() {
		customerID = keyboard.intInput();
	}
	
	public void printReceipt() {
		ListIterator<LineItem> iterator3 = itemsList.listIterator();
		while(iterator3.hasNext()) {
			LineItem item4 = iterator3.next();
			System.out.println(item4.getName() + "\t");
			System.out.println(item4.getQty() + "\t");
			System.out.println(item4.getPrice() + "\t");
			System.out.println(item4.getPrice() * item4.getQty());
		}
		System.out.println("\n" + "Total: " + this.getTotalPrice());
		this.applyDiscount();
		System.out.println("\n" + "Discount: " + this.discount);
		System.out.println("\n" + "TOTAL: " + this.getTotalPrice());
	}	
	
	public int getQuantity() {
		int qty = 0;
		
		for (int i = 0; i < itemsList.size(); i++) {
			qty += itemsList.get(i).getQty();
		}
		return qty;
	}
}