package model.CustomerFolder;

public class Customer {
	private String name, address;
	private int phoneNum;
	private boolean hasCraft;
	
	public Customer(String name, String address, int phoneNum, boolean hasCraft) {
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.hasCraft = hasCraft; 
	}
	
	// Setters n' Getters
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public int getPhoneNum() {
		return phoneNum;
	}
	
	public void setHasCraft(boolean hasCraft) {
		this.hasCraft = hasCraft;		
	}
	
	public boolean getHasCraft() {
		return hasCraft;
	}
}