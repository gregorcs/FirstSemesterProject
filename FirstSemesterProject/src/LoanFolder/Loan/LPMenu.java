package LoanFolder.Loan;

import input.KeyboardInput;

public class LPMenu {
	 private LP_Controller controller;
	 private UpdateLPMenu upmenu;
	 private LoanMainMenu menu;
	 private KeyboardInput keyboard;
	 
	 public LPMenu() {
		 controller = new LP_Controller();
		 keyboard = new KeyboardInput();
     }
	 
	 public void start() {
	        boolean isRunning = true;
	        int input; 
	        
	        while (isRunning) {
	            writeLPMenu();
	            input = keyboard.intInput();
	            switch (input) {
	                case 1:
	                  controller.createLP();
	                  break;
	                case 2:
	                  controller.getLP();
	                  break;
	                case 3:
	                  upmenu = new UpdateLPMenu();
	                  upmenu.updateLPMenu();
	                  break;
	                case 4:
	                  controller.deleteLP();
	                  break;
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

	    public void writeLPMenu() {
	        System.out.println("****** Edit Loan Product Menu ******");
	        System.out.println(" (1) Create Product");
	        System.out.println(" (2) Get Product");
	        System.out.println(" (3) Update Product");
	        System.out.println(" (4) Delete Product");
	        System.out.println(" (0) Return Product");
	        System.out.print("\n Choice:");

	    }   
}