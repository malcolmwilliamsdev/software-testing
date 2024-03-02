/*
 * Malcolm Williams
 * CS320
 * SNHU
 * 12FEB2024
 */
package contact;

public class Contact {
	private final String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	// constructor
	public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
		
		// validate id
		// non-null
		// 10 char max
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		// initialize fields
		this.id = id;
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);
	}
	
	/*
	 * Getters
	 */
  
	public String id() {
		return this.id;
	}

	public String firstName() {
		return this.firstName;
	}

	public String lastName() {
		return this.lastName;
	}
	
	public String phoneNumber() {
		return this.phoneNumber;
	}
	
	public String address() {
		return this.address;
	}
	
	/*
	 * Setters
	 */
	
	public void setFirstName(String value) {
		// validate first name
		// non-null
		// 10 char max
		if (value == null || value.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		this.firstName = value;
	}
	
	public void setLastName(String value) {
		// validate last name
		// non-null
		// 10 char max
		if (value == null || value.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		this.lastName = value;
	}
	
	public void setPhoneNumber(String value) {
		// validate phone number
		// non-null
		// 10 char exact
		if (value == null || value.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		this.phoneNumber = value;
	}
	
	public void setAddress(String value) {
		// validate address
		// non-null
		// 30 char max
		if (value == null || value.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.address = value;
	}
}