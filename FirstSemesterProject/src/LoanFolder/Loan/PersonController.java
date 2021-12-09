package LoanFolder.Loan;

import java.util.Scanner;

public class PersonController {
	
Scanner keyboard;
String niceties = "Please enter your ";
	
	public PersonController() {
	}
	
	public Person selectPerson () {
		keyboard = new Scanner(System.in);
		int phoneNum = 0;
		return PersonContainer.getInstance().searchForPerson(phoneNum);
	}
	
	/*CRUD METHODS*/
	public void createPerson() {
		String name, address, city;
		int postalCode, phone;
		
		keyboard = new Scanner(System.in);
		System.out.println(niceties + "full name: ");
		name = keyboard.nextLine();
		System.out.println(niceties + "address: ");
		address = keyboard.nextLine();
		System.out.println(niceties + "postal code: ");
		postalCode = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println(niceties + "city: ");
		city = keyboard.nextLine();
		System.out.println(niceties + "phone number: ");
		phone = keyboard.nextInt();
		PersonContainer.getInstance().createPerson(name, address, postalCode, city, phone);
	}
	
	public void readPerson() {
		PersonContainer.getInstance().readPerson(askForPhoneNumber());
	}
	
	public void readPerson(Person person) {
		PersonContainer.getInstance().readPerson(person);
	}
	
	public void updatePerson() {
		PersonContainer.getInstance();
		askForPhoneNumber();
	}

	public void deletePerson() {
		keyboard = new Scanner(System.in);
		int phoneNumber = askForPhoneNumber();
		PersonContainer.getInstance().deletePerson(phoneNumber);
	}
	
	public int askForPhoneNumber() {
		int phoneNumber;
		keyboard = new Scanner(System.in);
		System.out.println(niceties + "phone number to make changes: ");
		phoneNumber = keyboard.nextInt();
		
		return phoneNumber;
	}	
}