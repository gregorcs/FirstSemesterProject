package model.OrderFolder;

import java.util.ArrayList;
import java.util.ListIterator;
import model.LineItem;
import input.KeyboardInput;

public class Basket {
	private ArrayList<LineItem> item;
	private double totalPrice;
	private double finalPrice;
	private double discount;
	private int customerID;
	private KeyboardInput keyboard;
	
	public Basket() {
		this.item = new ArrayList<>();
		this.totalPrice = 0;
		this.discount = 0;
	}
	
	//add an item to the basket
	public void addToBasket(LineItem item) {
		this.item.add(item);
	}
	
	//show the basket
	public void showBasket() {
		ListIterator<LineItem> iterator = item.listIterator();
		while(iterator.hasNext()) {
			LineItem item1 = iterator.next();
			System.out.println(item1);
		} 
	}
	
	//remove an item from basket
	public void removeFromBasket(LineItem i) {
		ListIterator<LineItem> iterator1 = item.listIterator();
		while (iterator1.hasNext()) {
			LineItem item2 = iterator1.next();
			if (item2.getName().equals(i.getName())) {
				this.item.remove(i);
				break;
			}
		}
	}
	
	//total price of all items
	public double getTotalPrice() {
//ListIterator<LineItem> iterator2 = item.listIterator();
//this.totalPrice = 0;
//while(iterator2.hasNext()) {
//LineItem item3 = iterator2.next();
//	this.totalPrice = this.totalPrice + (item3.getProdPrice() * item3.getQty());
//}
		return item.get(1).getPrice();
	}
	
	//connect with Discount class & put customer IDs in groups. the ID will act like a discount code.
	//the discount amount will depend on the group the customer is in.
	private void applyDiscount() {
		customerID = keyboard.intInput();
	}
	
	public void printReceipt() {
		ListIterator<LineItem> iterator3 = item.listIterator();
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
}