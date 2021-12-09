package LoanFolder.Loan;
import java.util.ArrayList;
import java.util.Scanner;
import controller.*;

public class LP_Container {
	private ArrayList <LP> database;
	private LP_Controller controller;
	private UpdateLPMenu upmenu;
	private static LP_Container instance;
    Scanner keyboard;
    LP LPToModify, LPToReturn;
    
  public LP_Container() {
    	database = new ArrayList<>();
    	controller = new LP_Controller();
    }
    
    public static LP_Container getInstance() {
    	if (instance == null) {
    		instance = new LP_Container();
    	}
    	
    	return instance;
    }
    
    public void addLP(int barcode, String title, String artist, int publicationDate) {
		database.add(new LP(barcode, title, artist, publicationDate));
    }
   
    public void editLP(int barcode) {
    	LPToModify = findLP();
    	keyboard = new Scanner(System.in);
    	upmenu.updateLPMenu();
    }
    
    public void removeLP(int barcode) {
    	LP lp = findLP();
    	database.remove(lp);
    }
    
    public LP selectLP(int barcode) {
		LP lp = null;
    	for (LP i : database) {
    		if (i.getBarcode() == barcode) {
    			lp = i;
    	    }
        }
		return lp;
    }
    
    public LP findLP() {
    	int barcode = controller.askBarcode();
    	LP lp = null;
    	for (LP i : database) {
    		if (i.getBarcode() == barcode) {
    			lp = i;
    		} else {
    			System.out.println("We couldn't find an LP with this barcode.");
    		}
    	}
    	return lp;
    }
   
    public LP getLPToModify() {
    	return LPToModify;
    }

    public void printLP(LP lp) {
        System.out.println("Title: " + lp.getTitle());
        System.out.println("Artist: " + lp.getArtist());
        System.out.println("Barcode: " + lp.getBarcode());
        System.out.println("Publication date: " + lp.getDate());
    }
    
    public void printAllLP() {
    	if (database.size() == 0) {
    		System.out.println("No copies available.");
    	} else {
	    	for (LP item : database) {
	  
	    		if (item.isRented() == false) {
	    			printLP(item);
	    		}
	    	}
    	}
    }
    
    public int getID() {
    	return database.size();
    }    
}