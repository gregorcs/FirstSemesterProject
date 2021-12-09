package LoanFolder.Loan;

import input.KeyboardInput;


public class UpdateLPMenu {

	private LoanMainMenu menu;
	private LPMenu lpMenu;
	private LP_Container container;
	private KeyboardInput keyboard;
	
	 public void updateLPMenu() {
		 writeUpdateLPMenu();
	     LP_Container.getInstance();
	     updateLP();
	 }
	 
	 public UpdateLPMenu() {
		container = new LP_Container();
		keyboard = new KeyboardInput();
	 }
	 
	 public void updateLP() {
			LP lpToUpdate = container.getLPToModify();
			// container.printLP(lpToUpdate);
			String entnew = "Enter new ";
			
			System.out.println("Pick the attribute you'd like to edit: ");
			
			int userChoice = 0;
			userChoice = keyboard.intInput();
			
			switch (userChoice) {
			case 1:
				System.out.println(entnew + "barcode: ");
				lpToUpdate.setBarcode();
				break;
			case 2:
				System.out.println(entnew + "title: ");
				lpToUpdate.setTitle();
				break;
			case 3:
				System.out.println(entnew + "artist: ");
				lpToUpdate.setArtist();
				break;
			case 4:
				System.out.println(entnew + "date of publication: ");
				lpToUpdate.setDate();
				break;
			case 0:
				lpMenu = new LPMenu();
				lpMenu.start();
				break;
	        default:
	        	menu.errorMess();
	            break;
			}
		}
		    
		 private void writeUpdateLPMenu() {
			 System.out.println("****** Update Product Menu ******");
		     System.out.println(" (1) Modify Barcode");
		     System.out.println(" (2) Modify Title");
		     System.out.println(" (3) Modify Artist");
		     System.out.println(" (4) Modify Publication Date");
		     System.out.println(" (0) Return to LP Menu");  
		     System.out.print("\n Choice:");
		 }   
}