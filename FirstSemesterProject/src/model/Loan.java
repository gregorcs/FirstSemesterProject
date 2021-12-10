package model;

import java.util.ArrayList;

import model.ProductFolder.ProductForLoan;

public class Loan {

	private int ID;
	private Person borrower;
	private ArrayList<ProductForLoan> toLoanList;
	private String state = "new";
	private int period;
	
	public Loan(Person borrower, ArrayList<ProductForLoan> al, int period) {
		this.borrower = borrower;
		this.toLoanList = al;
		this.period = period;
	}
	
	//Getters & setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Person getBorrower() {
		return borrower;
	}
	public void setBorrower(Person borrower) {
		this.borrower = borrower;
	}
	public ArrayList<ProductForLoan> getToLoanList() {
		return toLoanList;
	}
	public void setToLoanList(ArrayList<ProductForLoan> toLoanList) {
		this.toLoanList = toLoanList;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
}
