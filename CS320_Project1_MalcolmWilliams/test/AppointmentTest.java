/*
 * Malcolm Williams
 * CS320
 * SNHU
 * 12FEB2024
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import appointment.Appointment;

class AppointmentTest {

	// provide valid appointments
	@Test
	void testValidAppointment() {
		for (int i = 0; i < 2; i++) {
			// arrange
			LocalDate testDate = LocalDate.now().plusDays(i); // today and tomorrow
			
			// act
			Appointment appointment = new Appointment("123", testDate, "my description");
			
			// assert
			assertTrue(appointment.id().equals("123"));
			assertTrue(appointment.date().equals(testDate));
			assertTrue(appointment.description().equals("my description"));
		}
	}
	
	// provide invalid id's
	@ParameterizedTest
	@ValueSource(strings = {"12345678901"})
	@NullSource
	void testInvalidId(String testId) {
		// assert
		assertThrows(IllegalArgumentException.class, () -> {
			// act
			new Appointment(testId, LocalDate.now(), "my description");
		});
	}
	
	// provide invalid dates
	@Test 
	void testInvalidDate(){
		// arrange
		LocalDate yesterday = LocalDate.now().plusDays(-1);
		LocalDate nullDate = null;
		
		//assert
		assertThrows(IllegalArgumentException.class, () -> {
			// act
			new Appointment("123", yesterday, "my description");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			// act
			new Appointment("123", nullDate, "my description");
		});
	}
	
	// provide invalid descriptions
	@ParameterizedTest
	@ValueSource(strings = {"123456789012345678901234567890123456789012345678901"})
	@NullSource
	void testInvalidDescription(String testDescription) {
		// assert
		assertThrows(IllegalArgumentException.class, () -> {
			// act
			new Appointment("123", LocalDate.now(), testDescription);
		});
	}
	
	
}
