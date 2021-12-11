package model;

import model.ProductFolder.Product;
import model.ProductFolder.ProductForSale;
import input.KeyboardInput;

public class LineItem extends Product{

	private int qty;
	private int prodID;
	private String prodName;
	private double prodPrice = 6.9;
	private KeyboardInput keyboard;
		
	public LineItem(ProductForSale p, int qty) {
		super(p.getID(), p.getName(), p.getLocation(), p.getPrice(), p.isAvailable());
		this.qty = qty;
		//this.setProdID(p.getID());
		//this.setProdName(p.getName());
		//this.setProdPrice(p.getPrice());
		}
	
		public void setQty(int qty) {
			this.qty = qty;
		}
		
		public int getQty() {
			return qty;
		}
		
		public int getProdID() {
			return prodID;
		}

		public void setProdID(int prodID) {
			this.prodID = prodID;
		}

		public String getProdName() {
			return prodName;
		}

		public void setProdName(String prodName) {
			this.prodName = prodName;
		}

		public double getProdPrice() {
			return prodPrice;
		}

		public void setProdPrice(double prodPrice) {
			this.prodPrice = prodPrice;
		}
	}
