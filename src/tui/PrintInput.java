package tui;

public class PrintInput {
	public void askForInt() {
		System.out.println("Enter the numbers below: ");
	}
	
	public void askForPositiveInt() {
		System.out.println("Enter a positive number: ");
	}
	
	public void askForIntAgain() {
		System.out.println("Enter a valid number: ");
	}
	
	public void askForString() {
		System.out.println("Enter text here: ");
	}
	
	public void askForStringAgain() {
		System.out.println("Your text is invalid, no numbers or characters allowed, try again: ");
	}
	
	public void askForIDAgain() {
		System.out.println("Incorrect ID, try again: ");
	}
}