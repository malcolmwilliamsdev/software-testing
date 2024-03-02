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

import appointment.Appointment;
import appointment.AppointmentService;

class AppointmentServiceTest {

	// add appointments unique and non-unique
	@Test
	void testAddAppointments() {
		// arrange
		AppointmentService service = new AppointmentService();
		Appointment appointment1 = new Appointment("1", LocalDate.now(), "my description");
		Appointment appointment2 = new Appointment("2", LocalDate.now(), "my description");
		Appointment appointment3 = new Appointment("2", LocalDate.now(), "my description");
		
		/*
		 * test unique id's
		 */
		
		// act
		service.addAppointment(appointment1);
		service.addAppointment(appointment2);
		
		//assert
		assertTrue(service.getAppointment("1").equals(appointment1));
		assertTrue(service.getAppointment("2").equals(appointment2));
		
		/*
		 * test non-unique
		 */
		
		// act/assert
		assertFalse(service.addAppointment(appointment3));
	}
	
	// remove appointment from service
	@Test
	void testRemoveAppointments() {
		// arrange
		AppointmentService service = new AppointmentService();
		Appointment appointment1 = new Appointment("1", LocalDate.now(), "my description");
		
		// assertion to verify removal of invalid id
		assertFalse(service.removeAppointment("1"));
		
		// add the appointment
		service.addAppointment(appointment1);
		
		// verify appointment is in the service prior to removal
		assertTrue(service.getAppointment("1").equals(appointment1));
		
		// remove appointment
		assertTrue(service.removeAppointment("1"));
		
		// verify appointment no longer in service
		assertNull(service.getAppointment("1"));
	}
}
