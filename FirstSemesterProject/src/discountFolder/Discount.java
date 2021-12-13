package discountFolder;

public class Discount {
	
	private int percentage;
	private int ID;
	final private int MAX_PERCENTAGE;
	
	public Discount(int percentage) {
		this.MAX_PERCENTAGE = 20;
		this.percentage = percentage;
		}

	public int getDiscPercentage() {
		return percentage;
	}

	/*public boolean setDiscPercentage(int percentage) {
		if ((percentage > 0) && (percentage <= MAX_PERCENTAGE)) {
			this.percentage = percentage;
			return true;
		} else {
			return false;
		}
	}*/

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getMAX_PERCENTAGE() {
		return MAX_PERCENTAGE;
	}
}
