/*
 * Malcolm Williams
 * CS320
 * SNHU
 * 12FEB2024
 */
package appointment;

import java.util.HashMap;

public class AppointmentService { 
	private HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();
	
	// add appointment
	public boolean addAppointment(Appointment newAppointment) {
		if (appointments.containsKey(newAppointment.id())) {
			return false;
		}
		
		appointments.put(newAppointment.id(), newAppointment);
		return true;
	}
	
	// delete appointment
	public boolean removeAppointment(String id) {
		return appointments.remove(id) == null ? false : true;
	}
	
	// search appointment id
	public Appointment getAppointment(String id) {
		return appointments.get(id);
	}
}
