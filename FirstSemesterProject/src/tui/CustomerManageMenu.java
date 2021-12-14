package tui;

import controller.CustomerController;
import input.KeyboardInput;

public class CustomerManageMenu {
		private KeyboardInput keyboard;
		private MainMenu mm;
		private PrintOuts po;
		private CustomerController ccontrol;

		public CustomerManageMenu() {
			keyboard = new KeyboardInput();
			mm = MainMenu.getInstance();
			po = new PrintOuts();
			ccontrol = new CustomerController();
		}

		public void start() {
			po.printCMM();
			CMM();
		}

		public void CMM() {
			boolean isRunning = true;
			int input;

			while(isRunning) {
				input = keyboard.intInput();

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
