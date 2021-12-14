package tui;

import input.KeyboardInput;

public class ScanTUI {
	private KeyboardInput kbInput;
	
	public ScanTUI() {
		kbInput = new KeyboardInput();
	}
	
	public void start() {
		boolean isRunning = true;
		int kbChoice = kbInput.intInput();
		
		while(isRunning) {
			printScanMenu();
			
			switch(kbChoice) {
				
			
			}
		}
	}
	
	
	private void printScanMenu() {
		System.out.println("****** Scan shopping ******");
		System.out.println("Scan(write) barcode, when finished press 1.");
		System.out.println(" (1) Proceed");
		System.out.println(" (0) Back");
	}
}
