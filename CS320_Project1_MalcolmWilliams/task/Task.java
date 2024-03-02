/*
 * Malcolm Williams
 * CS320
 * SNHU
 * 12FEB2024
 */
package task;

public class Task {
	private final String id;
	private String name;
	private String description;
	
	// constructor
	public Task(String id, String name, String description) {
		// validate id
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		
		this.id = id;
		setName(name);
		setDescription(description);
	}
	
	// get id
	public String id() {
		return this.id;
	}
	
	// get name
	public String name() {
		return this.name;
	}
	
	// get description
	public String description() {
		return this.description;
	}
	
	// set name
	public void setName(String value) {
		if (value == null || value.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		
		this.name = value;
	}
	
	// set description
	public void setDescription(String value) {
		if (value == null || value.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}

		this.description = value;
	}
}
