package com.cg.app.service;

import java.util.List;

import com.cg.app.model.Appointment;

public interface AppointmentService {
	public Appointment addAppointment(Appointment app);
	public Appointment updateAppointment(Appointment app);
	public Appointment deleteAppointment(Appointment app);
	public Appointment getAppointment(long bookingid);
	public List<Appointment> getAllAppointment();
}
