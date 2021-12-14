package controller;

import input.KeyboardInput;
import model.CustomerFolder.Customer;
import model.CustomerFolder.CustomerContainer;
import tui.MainMenu;
import tui.PrintOuts;

public class CustomerController {
	private KeyboardInput keyboard;
	MainMenu mm;
	PrintOuts po;
	CustomerContainer cc;
	
	public CustomerController() {
		keyboard = new KeyboardInput();
		mm = MainMenu.getInstance();
		cc = CustomerContainer.getInstance();
		po = new PrintOuts();
	}
	
	public void createObj() {
		po.printCreateCusHeader();
		po.printAskName();
		String name = keyboard.stringInput();
			
		po.printAskAddress();
		String address = keyboard.stringInput();
		
		po.printAskPhone();
		int phoneNum = keyboard.intInput();
		
		po.printAskCraft();
		boolean hasCraft = false;
		String bool = keyboard.stringInput();
		
		if (bool.equals("Y")) {
			hasCraft = true;
		}
				
		// Object Creation
		Customer C = new Customer(name, address, phoneNum, hasCraft);
		cc.create(C);
		
		po.printSuccess();	
	}
	
	public void updateName() {
		Customer C = getObj();
		po.printAskName();
		String name = keyboard.stringInput();
		C.setName(name);
		po.printSuccess();
	}
	
	public void updateAddress() {
		Customer C = getObj();
		po.printAskAddress();
		String address = keyboard.stringInput();
		C.setAddress(address);
		po.printSuccess();
	}
	
	public void updatePhoneNum() {
		Customer C = getObj();
		po.printAskPhone();
		int phoneNum = keyboard.intInput();
		C.setPhoneNum(phoneNum);
		po.printSuccess();
	}
	
	public Customer getObj() {
		return CustomerContainer.getInstance().searchForObj(askName());
	}
	
	public void readAll() {
		for (Customer C : cc.customersList) {
			System.out.println("Name: " + C.getName());
			System.out.println("Address: " + C.getAddress());
			System.out.println("Phone Number: " + C.getPhoneNum());
			System.out.println("==================================");
			System.out.println();
		}
	}
	
	public void deleteObj() {
		Customer C = getObj();
		cc.delete(C);
		po.printSuccess();
	}
	
	public String askName() {
		po.printAskName();
		String name = keyboard.stringInput();
		return name;
	}
}