package model.OrderFolder;

import java.util.ArrayList;
import java.util.ListIterator;
import model.ProductFolder.ProductForSale;
import input.KeyboardInput;

public class Basket {
	private ArrayList<ProductForSale> item;
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
	
	//add an item from the basket
	public void addToBasket(ProductForSale item) {
		this.item.add(item);
	}
	
	//show the basket
	public void showBasket() {
		ListIterator<ProductForSale> iterator = item.listIterator();
		while(iterator.hasNext()) {
			ProductForSale item1 = iterator.next();
			System.out.println(item1);
		} 
	}
	
	//remove an item from basket
	public void removeFromBasket(ProductForSale i) {
		ListIterator<ProductForSale> iterator1 = item.listIterator();
		while (iterator1.hasNext()) {
			ProductForSale item2 = iterator1.next();
			if (item2.getName().equals(i.getName())) {
				this.item.remove(i);
				break;
			}
		}
	}
	
	//total price of all items
	public double getTotalPrice() {
		ListIterator<ProductForSale> iterator2 = item.listIterator();
		this.totalPrice = 0;
		while(iterator2.hasNext()) {
			ProductForSale item3 = iterator2.next();
			this.totalPrice = this.totalPrice + (item3.getPrice() * item3.getAmount());
		}
		return this.totalPrice;
	}
	
	//connect with Discount class & put customer IDs in groups. the ID will act like a discount code.
	//the discount amount will depend on the group the customer is in.
	private void applyDiscount() {
		customerID = keyboard.intInput();
	}
	
	public void printReceipt() {
		ListIterator<ProductForSale> iterator3 = item.listIterator();
		while(iterator3.hasNext()) {
			ProductForSale item4 = iterator3.next();
			System.out.println(item4.getName() + "\t");
			System.out.println(item4.getAmount() + "\t");
			System.out.println(item4.getPrice() + "\t");
			System.out.println(item4.getPrice() * item4.getAmount());
		}
		System.out.println("\n" + "Total: " + this.getTotalPrice());
		this.applyDiscount();
		System.out.println("\n" + "Discount: " + this.discount);
		System.out.println("\n" + "TOTAL: " + this.getTotalPrice());
	}
}
