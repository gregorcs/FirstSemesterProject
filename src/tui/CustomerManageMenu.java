package tui;

import controller.CustomerController;
import input.KeyboardInput;

public class CustomerManageMenu {
		private KeyboardInput keyboard;
		private MainMenu mm;
		private PrintOuts po;
		private CustomerController ccontrol;
		boolean isRunning = true;
		
		public CustomerManageMenu() {
			keyboard = new KeyboardInput();
			mm = MainMenu.getInstance();
			po = new PrintOuts();
			ccontrol = new CustomerController();
		}
		
		public void start() {
			CMM();
		}
		
		public void CMM() {
			int input;
			
			while(isRunning) {	
				po.printCMM();
				input = keyboard.intInput();
				cusMngMenu(input);
			}
		}
		
		private void cusMngMenu(int input) {
			switch(input) {
			case 1:
				ccontrol.createObj();
				break;
			case 2:
				ccontrol.updateName();
				break;
			case 3:
				ccontrol.updateAddress();
				break;
			case 4:
				ccontrol.updatePhoneNum();
				break;
			case 5:
				ccontrol.deleteObj();
				break;
			case 6:
				ccontrol.readAll();
				break;
			case 0:
				mm.mainMenu();
				break;
			default:
				po.errorMessage();
				break;		
			}	
	  }			
}