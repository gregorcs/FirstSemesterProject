package LoanFolder.Loan;
import java.util.ArrayList;
import java.util.Scanner;

public class LoanContainer {
	private static LoanContainer instance;
	public ArrayList<Loan> loanList;
	Scanner keyboard;
	
	public LoanContainer () {
		loanList = new ArrayList<>();
	}

	public static LoanContainer getInstance() {
		if (instance == null) {
            instance = new LoanContainer();
		}

        return instance;
	}

	public Loan searchForLoan (int ID) {
		for (Loan tempLoan : loanList) {
			if (tempLoan.getId() == ID) {
				return tempLoan;
			}
		}
		return null;
	}
	
	
	/* CRUD METHODS */
	public void createLoan(Loan loan) {
		loanList.add(loan);
	}
	
	public void updateLoan() {
		
	}

	public void deleteLoan(Loan loan) {
		loanList.remove(loan);
	}
	
	public int createID() {
		int ID = loanList.size();
		
		if(searchForLoan(ID) == null) {				
			return ID;							
		} else {
			while (searchForLoan(ID) != null) {		
				ID++;
			}
			return ID;
		}
	}
	
	public ArrayList<Loan> getLoanList() {
		return loanList;
	}
}