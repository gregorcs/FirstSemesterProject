package LoanFolder.Loan;
import java.util.Scanner;

public class LP_Controller {
	Scanner keyboard;
	
    public void createLP() {
    	String title, artist;
    	int barcode, publicationDate;
    	keyboard = new Scanner(System.in);
    	
		System.out.println("Please enter the title of the LP: ");
		title = keyboard.nextLine();
		System.out.println("Please enter the name of the composing artist(s): ");
		artist = keyboard.nextLine();
		System.out.println("Please enter the barcode (found on back of the cover): ");
		barcode = keyboard.nextInt();
		System.out.println("Please enter the year the LP was published in: ");
		publicationDate = keyboard.nextInt();
		
		LP_Container.getInstance().addLP(barcode, title, artist, publicationDate);
    }
   
    
    public void getLP() {
    	LP lp = LP_Container.getInstance().findLP();
    	System.out.println("Barcode: " + lp.getBarcode());
		System.out.println("Title: " + lp.getTitle());
		System.out.println("Artist: " + lp.getArtist());
		System.out.println("Publication Date: " + lp.getDate());
    }
    
    public void getLP(LP lp) {
    	System.out.println("Barcode: " + lp.getBarcode());
		System.out.println("Title: " + lp.getTitle());
		System.out.println("Artist: " + lp.getArtist());
		System.out.println("Publication Date: " + lp.getDate());
    }
    
    public void updateLP() {
    	LP_Container.getInstance().editLP(askBarcode());
    }
    
    public void deleteLP() {
    	LP_Container.getInstance().removeLP(askBarcode());
    }

    public int askBarcode() {
    	int barcode;
		keyboard = new Scanner(System.in);
    	System.out.println("Please enter the barcode of the LP: ");
    	barcode = keyboard.nextInt();
    	
		return barcode;
    }

    public LP findLP() {
    	LP lp = LP_Container.getInstance().findLP();
    	return lp;
    }
    
    public void printAllLP() {
    	LP_Container.getInstance().printAllLP();
    }
    
    public String getAvailability(LP lp) {
    	if (lp.isRented() == true) {
    		return "Currently unavailable";
    	}
    	else {
    		return "Currently available";
    	}
    	
    }
}