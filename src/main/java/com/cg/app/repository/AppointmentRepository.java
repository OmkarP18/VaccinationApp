package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.app.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	public boolean findByMobileno(long mobileno);

	public Appointment findByBookingid(long bookingid);
	
}
