package model.OrderFolder;

import java.util.ArrayList;

import discountFolder.Discount;

public class ItemOrder extends Order{
	
	public ItemOrder(String customerName, Basket basket) {
		super(customerName, basket);
	}
}
