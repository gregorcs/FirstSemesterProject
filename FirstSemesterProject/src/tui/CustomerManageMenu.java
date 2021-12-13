package tui;

import input.KeyboardInput;

public class CustomerManageMenu {
		kbInput = new KeyboardInput();
		mm = MainMenu.getInstance();
		PrintOuts po = new PrintOuts();
		
	public CustomerManageMenu() {
		
	}
	
	public void start() {
		CMM();
	}
	
	public void CMM() {
		boolean isRunning = true;
		int input;
		
		while(isRunning) {
			po.printCMM();
			
			input = kbInput.intInput();
			
				switch(input) {
				case 1:
					ccontrol.updateName();
					break;
				case 2: 
					ccontrol.deleteObj();
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
	}