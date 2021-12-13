package CustomerFolder;

public class Customer {
	private String name;
	private boolean hasCraft;
	
	public Customer(String name, boolean hasCraft) {
		this.name = name;
		this.hasCraft = hasCraft; 
	}
	
	// Setters n' Getters
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setHasCraft(boolean hasCraft) {
		this.hasCraft = hasCraft;		
	}
	
	public boolean getHasCraft() {
		return hasCraft;
	}
}