package controller;

import input.KeyboardInput;
import model.CustomerFolder.Customer;
import model.CustomerFolder.CustomerContainer;
import tui.MainMenu;
import tui.PrintOuts;

public class CustomerController {
	private KeyboardInput keyboard;
	MainMenu mm;
	Customer c;
	PrintOuts po;
	CustomerContainer cc;
	
	public CustomerController() {
		keyboard = new KeyboardInput();
		mm = MainMenu.getInstance();
		cc = CustomerContainer.getInstance();
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
		boolean hasCraft = false;;
		String bool = keyboard.stringInput();
		
		if (bool.equals("Y")) {
			c.setHasCraft(true);
		}
				
		po.printSuccess();
		
		// Object Creation
		Customer C = new Customer(name, address, phoneNum, hasCraft);
		cc.create(C);
	}
	
	public void updateName() {
		Customer C = getObj();
		String name = keyboard.stringInput();
		C.setName(name);
	}
	
	public void updateAddress() {
		Customer C = getObj();
		String address = keyboard.stringInput();
		C.setAddress(address);
	}
	
	public void updatePhoneNum() {
		Customer C = getObj();
		int phoneNum = keyboard.intInput();
		C.setPhoneNum(phoneNum);
	}
	
	public Customer getObj() {
		return CustomerContainer.getInstance().searchForObj(askName());
	}
	
	public void deleteObj() {
		Customer C = getObj();
		cc.delete(C);
	}
	
	public String askName() {
		po.printAskName();
		String name = keyboard.stringInput();
		return name;
	}
}