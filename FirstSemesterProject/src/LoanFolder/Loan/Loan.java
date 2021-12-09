package LoanFolder.Loan;

public class Loan {

	private int id;
	private Person borrower;
	private LP lp;
	private String state = "new";
	private int period;

	public Loan(Person borrower, LP lp, int period) {
		this.id = LoanContainer.getInstance().getID();
		this.borrower = borrower;
		this.setLp(lp);
		this.period = period;
	}

	/* GETTERS AND SETTERS*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getBorrower() {
		return borrower;
	}

	public void setBorrower(Person borrower) {
		this.borrower = borrower;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public LP getLp() {
		return lp;
	}

	public void setLp(LP lp) {
		this.lp = lp;
	}
}