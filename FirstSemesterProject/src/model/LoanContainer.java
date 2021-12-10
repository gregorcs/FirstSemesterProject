package model;

import java.util.ArrayList;

public class LoanContainer {
	
	//variable declarations
	private ArrayList<Loan> loanDatabase;
	private static LoanContainer instance;
	
	protected LoanContainer() {
		loanDatabase = new ArrayList<Loan>();
	}
	
	//Returns instance
	public static LoanContainer getInstance() {
		if (instance == null) {
            instance = new LoanContainer();
		}
        return instance;
	}

	public Loan searchForObj(int ID) {
		for (Loan product : loanDatabase) {
			if (product.getID() == ID) {
				return product;				
			}
		}
		return null;						
	}
	
	//CRUD Methods

	public void create(Loan obj) {
		obj.setID(createID());
		loanDatabase.add(obj);
	}
	
	public void delete(Loan obj) {
		loanDatabase.remove(obj);
	}

	public void update(Loan obj) {
		loanDatabase.set(getID(obj), obj);
	}

	public int getID(Loan obj) {
		return loanDatabase.indexOf(obj);

	}
	
    public int createID() {
		int ID = loanDatabase.size();
		
		if(searchForObj(ID) == null) {				
			return ID;							
		} else {
			while (searchForObj(ID) != null) {		
				ID++;
			}
			return ID;
		}
	}

	public int arraySize() {
		return loanDatabase.size();
	}
	public ArrayList<Loan> getLoansDatabase() {
		return loanDatabase;
	}
}
