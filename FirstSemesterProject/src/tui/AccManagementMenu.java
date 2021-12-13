package tui;

import controller.PersonController;
import input.KeyboardInput;
import model.PersonFolder.*;

public class AccManagementMenu {
	
		private KeyboardInput kbInput;
		MainMenu mm = MainMenu.getInstance();
		PrintOuts po = new PrintOuts();
		PersonController percontrol = new PersonController();
		PersonContainer percon = PersonContainer.getInstance();
		
		
		public AccManagementMenu() {
			kbInput = new KeyboardInput();
			mm = MainMenu.getInstance();
		}
		
		public void start() {
			AMM();
		}
		
		public void AMM() {
			boolean isRunning = true;
			int input;
			
			while(isRunning) {
				po.printAMM();
				
				input = kbInput.intInput();
				
					switch(input) {
					case 1:
						percontrol.updateUN();
						break;
					case 2:
						percontrol.updatePass();
						break;
					case 3: 
						percontrol.deleteObj();
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