package LoanFolder.Loan;

public class Person {
	
	private String name;
	private String address;
	private int postalCode;
	private String city;
	private int phone;
	
	public Person(String name, String address, int postalCode, String city, int phone) {
		this.setName(name);
		this.setAddress(address);
		this.setPostalCode(postalCode);
		this.setCity(city);
		this.setPhone(phone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
}