package input;
import java.util.Scanner;

import tui.PrintInput;

public class KeyboardInput {

	private Scanner sc;
	private PrintInput printStatement;
	
	//Constructor
	public KeyboardInput() {
		printStatement = new PrintInput();
	};
	
	//String input
	public String StringInput() {
		String input = "-1";
		boolean correctInput = false;
		
		//printStatement.askForString();
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
			printStatement.askForStringAgain();
			return false;
		}
	}
	
	//int input
	public int intInput() {
		int input = -1;
		boolean correctInput = false;

		//printStatement.askForInt();
		//loops until user enters and integer, returns that integer
		while (!correctInput) {
			sc = new Scanner(System.in);

			try {
				input = sc.nextInt();
				
				correctInput = isIntPositive(input);
			} catch (Exception e) {
				printStatement.askForIntAgain();
			}
		}
		return input;
	}
	
	//int logic
	public boolean isIntPositive(int num) {
		//checks if bigger or equal to 0 and checks against biggest possible int 
		if ( (num >= 0) && (num < 4294967295L)) {
			return true;
		}
		else {
			printStatement.askForPositiveInt();
			return false;
		}
	}
}
