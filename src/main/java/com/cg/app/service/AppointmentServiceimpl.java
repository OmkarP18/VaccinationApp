package com.cg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.exception.AppointmentException;
import com.cg.app.exception.VaccineRegistrationException;
import com.cg.app.model.Appointment;
import com.cg.app.repository.AppointmentRepository;

@Service
public class AppointmentServiceimpl implements AppointmentService {


	@Autowired
	private AppointmentRepository appointmentrepo;


	@Override
	public Appointment addAppointment(Appointment app) {

		return appointmentrepo.save(app);
	}

	@Override
	public Appointment updateAppointment(Appointment app) throws AppointmentException {

		if(appointmentrepo.findByMobileno(app.getMobileno()))
			return appointmentrepo.save(app);

		throw new AppointmentException("there is no appointment to update" );
	}


	@Override
	public Appointment deleteAppointment(Appointment app) throws AppointmentException {

		if(appointmentrepo.findByMobileno(app.getMobileno())) {
			appointmentrepo.delete(app);
			return app;
		}

		throw new AppointmentException("there is no appointment to delete" );
	}

	@Override
	public Appointment getAppointment(long bookingid)throws AppointmentException {

		Appointment appointment = appointmentrepo.findByBookingid(bookingid);

		if(appointment!=null)
			return appointment;

		throw new AppointmentException("there is no appointment" );

	}

	@Override
	public List<Appointment> getAllAppointment()throws AppointmentException {
		
		List<Appointment> appointment=appointmentrepo.findAll();
		
		if(appointment.size()>0)
			return appointment;
		
		throw new AppointmentException("there are no appointments to display " );
	}

}
