/*
 * Malcolm Williams
 * CS320
 * SNHU
 * 12FEB2024
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import contact.*;
import contact.ContactService.ContactField;

class ContactServiceTest {

	
	Contact contact1 = new Contact("0", "Malcolm", "Williams", "0123456789", "124 Conch Street");
	Contact contact2 = new Contact("1", "Malik", "Harrison", "0987654321", "120 Conch Street");
	Contact contact3 = new Contact("1", "Mario", "Sanchez", "1029384756", "122 Conch Street");
	
	// adding unique contacts
	@Test
	void testAddUniqueContacts() {		
		ContactService service = new ContactService();
		
		service.addContact(contact1);
		service.addContact(contact2);
		
		Contact serviceContact1 = service.getContact(contact1.id());
		Contact serviceContact2 = service.getContact(contact2.id());
		
		assertTrue(serviceContact1.equals(contact1));
		assertTrue(serviceContact2.equals(contact2));
	}
	
	// adding non-unique contacts
	@Test
	void testAddConflictingContacts() {		
		ContactService service = new ContactService();
		
		service.addContact(contact2);
		
		assertFalse(service.addContact(contact3));
	}
	
	// deleting a contacts
	@Test
	void testDeleteContact() {		
		ContactService service = new ContactService();
		
		service.addContact(contact1);
		
		assertTrue(service.deleteContact(contact1.id()));
		assertNull(service.getContact(contact1.id()));
	}
	
	/*
	 * Updating Contact Tests
	 */
	
	@ParameterizedTest
	@EnumSource(ContactField.class)
	void testUpdateContact(ContactField field) {
		ContactService service = new ContactService();
		
		service.addContact(contact1);
		assertTrue(service.updateContact(contact1.id(), field, "0123456789"));
	}
	
	
	
}
