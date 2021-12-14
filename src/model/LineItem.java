package model;

import model.ProductFolder.Product;
import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;

public class LineItem extends Product{

	private int qty;
	private int prodID;
	private String prodName;
	private double prodPrice;
		
	public LineItem(ProductForSale p, int qty) {
		super(p.getID(), p.getName(), p.getLocation(), p.getPrice(), p.isAvailable());
		this.qty = qty;
		this.prodPrice = p.getPrice();
		this.prodName = p.getName();
		this.prodID = p.getID();
		
		ProductContainer.getInstance().searchForObj(p).DecrementStock(qty);
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
