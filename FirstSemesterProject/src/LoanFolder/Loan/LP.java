package LoanFolder.Loan;
import java.util.Scanner;

public class LP {
    private int barcode, publicationDate;
    private String title, artist;
    Scanner keyboard;
    private boolean isRented = false;
    
    public LP(int barcode, String title, String artist, int publicationDate) {
        this.title = title;
        this.artist = artist;
        this.publicationDate = publicationDate;
		this.barcode = barcode;
    }

	public int getBarcode() {
		return barcode;
	}
	
	public void setBarcode() {
		barcode = keyboard.nextInt();
	}
	
	public String getTitle() {
		return title;
	}
	
    public void setTitle() {
    	title = keyboard.nextLine();
	}
	
	public String getArtist() {
		return artist;
	}
	
    public void setArtist() {
    	artist = keyboard.nextLine();
	}
	
	public int getDate() {
		return publicationDate;
	}
	
    public void setDate() {
    	publicationDate = keyboard.nextInt();
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}
}