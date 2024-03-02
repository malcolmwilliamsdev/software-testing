/*
 * Malcolm Williams
 * CS320
 * SNHU
 * 12FEB2024
 */
package appointment;

import java.time.LocalDate;

public class Appointment {
	// id non-updatable
	private final String id;
	private LocalDate date;
	private String description;
	
	public Appointment(String id, LocalDate date, String description) {
		// validate id
		// non-null
		// 10 char max
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("invalid id");
		}
		
		// initialize fields
		this.id = id;
		setDate(date);
		setDescription(description);
	}
	
	/*
	 * Getters
	 */
	
	public String id() {
		return this.id;
	}
	
	public LocalDate date() {
		return this.date;
	}
	
	public String description() {
		return this.description;
	}
	
	
	/*
	 * Setters
	 */
	
	public void setDate(LocalDate date) {
		// validate date
		// non-null
		// not in past
		LocalDate today = LocalDate.now();
		if (date == null || today.isAfter(date)) {
			throw new IllegalArgumentException("invalid date");
		}
		
		// set date
		this.date = date;
	}
	
	public void setDescription(String description) {
		// validate description
		// non-null
		// 50 char max
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("invalid description");
		}
		
		// set description
		this.description = description;
	}
}
