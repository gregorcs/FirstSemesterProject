package input;
import java.util.Scanner;

public class KeyboardInput {

	private Scanner sc;
	
	//Constructor
	public KeyboardInput() {};
	
	//String input
	public String StringInput() {
		String input = "-1";
		boolean correctInput = false;
		
		askForString();
		//while statement checks if inputed string is from a to z
		while (!correctInput) {
			sc = new Scanner(System.in);
			if (sc.hasNextLine()) {
				input = sc.nextLine();
			}
			correctInput = isStringCorrect(input);
		}
		return input;
	}
	
	//String logic
	public boolean isStringCorrect(String str) {
		if (str.matches("[ a-zA-Z]+")) {
			return true;
		}
		else {
			askForStringAgain();
			return false;
		}
	}
	
	//int input
	public int intInput() {
		int input = -1;
		boolean correctInput = false;

		askForInt();
		//loops until user enters and integer, returns that integer
		while (!correctInput) {
			sc = new Scanner(System.in);

			try {
				input = sc.nextInt();
				
				correctInput = isIntPositive(input);
			} catch (Exception e) {
				askForIntAgain();
			}
		}
		return input;
	}
	
	//int logic
	public boolean isIntPositive(int num) {
		if ( (num >= 0) && (num < 4294967295L)) {
			return true;
		}
		else {
			askForPositiveInt();
			return false;
		}
	}
	

	//print statements for integer input
	public void askForInt() {
		System.out.println("Enter the numbers below: ");
	}
	public void askForPositiveInt() {
		System.out.println("Enter a positive number: ");
	}
	public void askForIntAgain() {
		System.out.println("Enter a valid number: ");
	}
	
	//print statements for String input
	public void askForString() {
		System.out.println("Enter text here: ");
	}
	public void askForStringAgain() {
		System.out.println("Your text is invalid, no numbers or characters allowed, try again: ");
	}
}
