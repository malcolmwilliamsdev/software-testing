/*
 * Malcolm Williams
 * CS320
 * SNHU
 * 12FEB2024
 */
package contact;
import java.util.HashMap;

public class ContactService {
	// data structure to hold contacts
	private HashMap<String, Contact> contacts = new HashMap<String, Contact>();
	
	public enum ContactField {
	  FIRSTNAME,
	  LASTNAME,
	  PHONENUMBER,
	  ADDRESS
	}
	
	// insert a contact
	public boolean addContact(Contact newContact) {
		String id = newContact.id();
		if (contacts.containsKey(id)) {
			return false;
		}
		contacts.put(id, newContact);
		return true;
	}
	
	// remove a contact
	public boolean deleteContact(String id) {
		return contacts.remove(id) == null ? false : true;
	}
	
	// retrieve a contact
	public Contact getContact(String id) {
		Contact contact = contacts.get(id);

		return contact;
	}
	
	// update a contact field
	public boolean updateContact(String id, ContactField field, String value) {
		Contact contact = getContact(id);
		
		if (contact == null) {
			return false;
		}
		
		switch (field) {
		case ContactField.FIRSTNAME:
			contact.setFirstName(value);
			break;
		case ContactField.LASTNAME:
			contact.setLastName(value);
			break;
		case ContactField.PHONENUMBER:
			contact.setPhoneNumber(value);
			break;
		case ContactField.ADDRESS:
			contact.setAddress(value);
			break;
		}
		
		return true;
	}
	
	
}
