package input;
import java.util.Scanner;

import tui.PrintInput;

public class KeyboardInput {

	private Scanner sc;
	private PrintInput printStatement;
	private String numRegex = ".*[0-9].*";
	private String alphaRegex = "[ a-zA-Z]+";
	
	//Constructor
	public KeyboardInput() {
		printStatement = new PrintInput();
	};
	
	//String input
	public String stringInput() {
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
		if (str.matches(alphaRegex)) {
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
				
				correctInput = numIsPositive(input);
			} catch (Exception e) {
				printStatement.askForIntAgain();
			}
		}
		return input;
	}
	
	//int logic
	//is this good? converts int to double, idk how to do it
	public boolean numIsPositive(double num) {
		//checks if bigger or equal to 0 and checks against biggest possible int 
		if ( (num >= -1) && (num < 4294967295L)) {
			return true;
		}
		else {
			printStatement.askForPositiveInt();
			return false;
		}
	}
	
	public double doubleInput() {
		double result = -1.00;
		boolean correctInput = false;
		
		while(!correctInput) {
			sc = new Scanner(System.in);
			
			try {
				result = sc.nextDouble();
				correctInput = numIsPositive(result);
			} catch (Exception e) {
				printStatement.askForIntAgain();
			}
		}
		return result;
	}
}

