package com.cg.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.model.AdharCard;
import com.cg.app.model.Appointment;
import com.cg.app.model.IdCard;
import com.cg.app.model.Member;
import com.cg.app.model.VaccinationCenter;
import com.cg.app.model.VaccineRegistration;
import com.cg.app.service.AppointmentService;
import com.cg.app.service.VaccineRegistrationService;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {
	@Autowired
	private  AppointmentService appointmentService;
	
	//localhost:7000/appointment/registerAppointment
	
	/*
	 * {

    "mobileno": "8698312433",
    "member": {
        "idCard":{
             "name": "Ravi",
             "dob": "05/02/1990",
             "gender": "male",
             "address" : "banjara hills",
             "city": "hydrabad",
             "state": "telangana",
             "pincode": "4565654"
        }
    },
    "center":{
        "centername": "SankhPHC",
        "address": "Sankh",
        "city": "Sangli",
        "state":"Maharashatra",
        "pincode":"4565654"
    },
    "dateofbooking":"2022-01-28",
    "slot": "slot1",
    "bookingstatus":"true"
}
	 */
	
	
	
	@PostMapping("/registerAppointment")
	public Appointment addAppointementHandler (@Valid @RequestBody Appointment appointment) {

		
		return appointmentService.addAppointment(appointment);

	}
	
	@PutMapping("/update")
	public Appointment updateAppointment(@Valid @RequestBody Appointment appointment) {
		
		return appointmentService.updateAppointment(appointment);
		
	}
	
	

	@DeleteMapping("/delete/{bookingid}")
	public Appointment deleteMember(@PathVariable("bookingid") Integer bookingid) {
		
		Appointment appointment = appointmentService.getAppointment(bookingid);
		
		return appointmentService.deleteAppointment(appointment);
		
	}
	
	@GetMapping("/findbyID/{bookingid}")
	public Appointment getAppointment(@PathVariable("bookingid") Integer bookingid) {
		
		return appointmentService.getAppointment(bookingid);
		
	}
	

	@GetMapping("/findall")
	public List<Appointment> getAllAppointments(){
		
		return appointmentService.getAllAppointment();
	}
	
	
	
}
