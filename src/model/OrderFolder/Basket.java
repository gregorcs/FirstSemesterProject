package model.OrderFolder;

import java.util.ArrayList;
import java.util.ListIterator;

import discountFolder.Discount;
import model.LineItem;

public class Basket {
	private ArrayList<LineItem> itemsList;
	private ArrayList<Discount> listOfDiscounts;
	private int finalDiscount;
	
	public Basket(ArrayList<LineItem> itemsList, ArrayList<Discount> listOfDiscounts) {
		this.itemsList = new ArrayList<>();
		this.itemsList = itemsList;
		this.listOfDiscounts = listOfDiscounts;
	}
	
	public void addToBasket(LineItem item) {
		this.itemsList.add(item);
	}
	
	public void showBasket() {
		ListIterator<LineItem> iterator = itemsList.listIterator();
		while(iterator.hasNext()) {
			LineItem item1 = iterator.next();
			System.out.println(item1);
		} 
	}

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
	
	public double getTotalPrice() {	
		double singleProdPrice;			
		double lineItemPrice = 0;		
		double finalPrice = 0;			
		int qtyToBuy;
		
		for (int i = 0; i < itemsList.size(); i++) {
			lineItemPrice = 0;
			singleProdPrice = itemsList.get(i).getPrice();
			qtyToBuy = itemsList.get(i).getQty();
			
			lineItemPrice += (singleProdPrice * qtyToBuy);
			
			finalPrice += lineItemPrice;
			finalPrice = getFinalPrice(finalPrice, calculateDiscount());
		}
		
		return finalPrice;
	}
	
	public int getQuantity() {
		int qty = 0;
		
		for (int i = 0; i < itemsList.size(); i++) {
			qty += itemsList.get(i).getQty();
		}
		return qty;
	}
	
	private int calculateDiscount() {
		int result = 0;
		for (Discount discount : listOfDiscounts) {
			result = getFinalDiscount() + discount.getDiscPercentage();
		}
		return result; 
	}
	
	private double getFinalPrice(double price, double discountPerc) {
		double discount = 0.00;
		
		discount = ((price * discountPerc) / 100);
		
		price -= discount;
		return price;
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
	}

	public ArrayList<Discount> getListOfDiscounts() {
		return listOfDiscounts;
	}

	public void setListOfDiscounts(ArrayList<Discount> listOfDiscounts) {
		this.listOfDiscounts = listOfDiscounts;
	}

	public int getFinalDiscount() {
		return finalDiscount;
	}

	public void setFinalDiscount(int finalDiscount) {
		this.finalDiscount = finalDiscount;
	}
}