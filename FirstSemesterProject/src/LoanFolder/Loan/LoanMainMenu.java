package LoanFolder.Loan;

import input.KeyboardInput;
import tui.MainMenu;

public class LoanMainMenu {
    private LoanMenu loanMenu;
    private PersonMenu personMenu;
    private LPMenu lpMenu;
    private KeyboardInput keyboard;
    
    public LoanMainMenu() {
    	keyboard = new KeyboardInput();
    }
    
    public void start() {
        mainMenu();
    }
    
    public void mainMenu() {
        boolean isRunning = true;
        int input;
        
        while (isRunning) {
            printMainMenu();
            input = keyboard.intInput();
            switch (input) {
                case 1:
                  personMenu = new PersonMenu();
                  personMenu.start();
                  break;
                case 2:
                  lpMenu = new LPMenu(); 	
                  lpMenu.start();
                  break;
                case 3:
                  loanMenu = new LoanMenu();
                  loanMenu.start();
                  break;
                case 0:
                  MainMenu menu = new MainMenu();
                  isRunning = false;
                  menu.start();
                  break;
                default:
                	errorMess();
                  break;
            }
        }
    }

   public void printMainMenu() {
        System.out.println("****** Loan Menu ******");
        System.out.println(" (1) Borrower menu");
        System.out.println(" (2) Product menu");
        System.out.println(" (3) Loan menu");
        System.out.println(" (0) Back to main menu");
        System.out.print("\n Choice:");
        
    }
   
    public void errorMess() {
    	System.out.println("Unknown error occurred.");
    }
    public void in_errorMess() {
      	 System.out.println("Input must be a number - please try again.");
       }
}
