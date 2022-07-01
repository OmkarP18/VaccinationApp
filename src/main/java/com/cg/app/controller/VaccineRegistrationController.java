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

import com.cg.app.model.Member;
import com.cg.app.model.Vaccine;
import com.cg.app.model.VaccineRegistration;
import com.cg.app.service.VaccineRegistrationService;
import com.cg.app.service.VaccineService;

@RestController
@RequestMapping("/vaccineregistration")
@CrossOrigin(origins = "*")
public class VaccineRegistrationController {
	
	@Autowired
	private  VaccineRegistrationService vaccineregservice;
	
	
	@PostMapping("/addvaccineregistration")
	public VaccineRegistration addVaccineRegistration (@Valid @RequestBody VaccineRegistration reg)
	{
		VaccineRegistration newvaccineregistration=new VaccineRegistration();
		
		newvaccineregistration.setMobileno(reg.getMobileno());
		
		newvaccineregistration.setDateofregistration(reg.getDateofregistration());
		
		return vaccineregservice.addVaccineRegistration(newvaccineregistration);
		
	}
	
	
	@PutMapping("/updatevaccineregistration")
	public VaccineRegistration updateVaccineRegistration (@Valid @RequestBody VaccineRegistration reg) {
		return vaccineregservice.updateVaccineRegistration(reg);
	}
	
	
	@DeleteMapping("/deletevaccineregistration")
	public boolean deleteVaccineRegistration (VaccineRegistration reg) {
		VaccineRegistration deletevaccinereg= vaccineregservice.getVaccineRegistration(reg.getMobileno());
		
		return vaccineregservice.deleteVaccineRegistration(deletevaccinereg);
	}
	
	
	@GetMapping("/vaccineregistrationdetails/{mobileno}")
	public VaccineRegistration getVaccineRegistration (@PathVariable long mobileno)
	{
		return vaccineregservice.getVaccineRegistration(mobileno);
	}
	
	@GetMapping("/vaccineregistrationdetailsofmember/{mobileno}")
	public List<Member> getAllMember(@PathVariable long mobileno){
		
		return vaccineregservice.getAllMember(mobileno);
	}
	
	@GetMapping("/allvaccineregistrationdetails")
	public List<VaccineRegistration> getAllVaccineRegistrations(){
		return vaccineregservice.getAllVaccineRegistrations();
		
	}
}
