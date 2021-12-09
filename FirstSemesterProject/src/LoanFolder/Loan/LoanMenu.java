package LoanFolder.Loan;

import input.KeyboardInput;

public class LoanMenu {
    LoanController loanController;
    LP_Controller lpController;
    LoanMainMenu menu;
    KeyboardInput keyboard;
    
    public LoanMenu() {
    	loanController = new LoanController();
    	lpController = new LP_Controller();
    	keyboard = new KeyboardInput();
    }

    public void start() {
        loanMenu();
    }

    private void loanMenu() {
        boolean isRunning = true;
        int input;
        
        while (isRunning) {
        	writeLoanMenu();
        	input = keyboard.intInput();
            switch (input) {
                case 1:
                	loanController.createLoan();
                	break;
                case 2:
                	lpController.printAllLP();
                	break;
                case 3:
                	loanController.printAllLoans();
                	break;
                case 4:
                	loanController.returnLP();
                case 0:
                	menu = new LoanMainMenu();
                	menu.start();
                	break;
                default:
                	menu.errorMess();
                	break;
            }
        }
    }
    
    private void writeLoanMenu() {
        System.out.println("****** Loan menu ******");
        System.out.println(" (1) Create loan");
        System.out.println(" (2) Print available LPs");
        System.out.println(" (3) Print active loans");
        System.out.println(" (4) Return LP");
        System.out.println(" (0) Return to Main Menu");
        System.out.print("\n Choice:");
    }
}