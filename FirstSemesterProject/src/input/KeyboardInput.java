package input;
import java.util.Scanner;

public class KeyboardInput {

	private Scanner sc;
	private String alphaRegex = "[ a-zA-Z]+";
	
	//Constructor
	public KeyboardInput() {
	};
	
	public String input() {
		String input = "-1";
		sc = new Scanner(System.in);
		
		if (sc.hasNextLine()) {
			return input = sc.nextLine();
		}
		return input;
	}
	
	//String input
	public String stringInput() {
		String input = "-1";
		boolean correctInput = false;
		
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
		} else {
			printIncorrectInput();
			return false;
		}
	}
	
	//int input
	public int intInput() {
		int input = -1;
		boolean correctInput = false;

		while (!correctInput) {
			sc = new Scanner(System.in);

			try {
				input = sc.nextInt();
				
				correctInput = numIsPositive(input);
			} catch (Exception e) {
				printIncorrectInput();
			}
		}
		return input;
	}
	
	//int logic
	public boolean numIsPositive(double num) {
		if ( (num >= 0) && (num < 4294967295L)) {
			return true;
		} else {
			printIncorrectInput();
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
				printIncorrectInput();
			}
		}
		return result;
	}
	
	private void printIncorrectInput() {
		System.out.println("Incorrect input, try again: ");
	}
}

