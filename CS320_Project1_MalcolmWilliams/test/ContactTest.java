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
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import contact.Contact;

class ContactTest {

	// Valid contact
	@Test
	void testContact() {
		Contact contact = new Contact("123", "Malcolm", "Williams","9099632559", "123 Home St."); 
		assertTrue(contact.id().equals("123"));
		assertTrue(contact.firstName().equals("Malcolm"));
		assertTrue(contact.lastName().equals("Williams"));
		assertTrue(contact.phoneNumber().equals("9099632559"));
		assertTrue(contact.address().equals("123 Home St."));
	}
	
	// Invalid Id
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"01234567890"})
	void testId(String testStr) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(testStr, "f-name", "l-name", "0123456789", "address"); 
		});
	}
	
	// Invalid first name
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"01234567890"})
	void testFirstName(String testStr) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", testStr, "l-name", "0123456789", "address"); 
		});
	}
	
	// Invalid last name
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"01234567890"})
	void testLastName(String testStr) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "f-name", testStr, "0123456789", "address"); 
		});
	}
	
	// Invalid phone number
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"012345678", "01234567890"})
	void testPhoneNumber(String testStr) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "f-name", "l-name", testStr, "address"); 
		});
	}

	// Invalid address
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"0123456789012345678901234567890"})
	void testAddress(String testStr) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "f-name", "l-name", "0123456789", testStr); 
		});
	}
}
