
import input.KeyboardInput;

public class Main {


		public static void main (String args[]) {
			KeyboardInput kbi = new KeyboardInput();
			int phoneNum;
			phoneNum= kbi.intInput();
			
			System.out.println("you enter the number " + phoneNum);
			
			System.out.println("=======================");
			
			String name;
			name = kbi.StringInput();
			System.out.println("your name is : " + name);

		}
}
