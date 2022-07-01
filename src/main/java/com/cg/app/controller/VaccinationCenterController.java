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

import com.cg.app.model.VaccinationCenter;
import com.cg.app.service.VaccinationCenterService;

@RestController
@RequestMapping("/vaccinecenter")
@CrossOrigin(origins = "*")
public class VaccinationCenterController {
	
	@Autowired
	private VaccinationCenterService centerService;

	@PostMapping("/addVaccinationcenter")
	public VaccinationCenter addVaccinationCenter( @Valid @RequestBody VaccinationCenter center) {
		
		center.setCentername(center.getCentername());
		
		center.setAddress(center.getAddress());
		
		center.setCity(center.getCity());
		
		center.setState(center.getState());
		
		center.setPincode(center.getPincode());
		
		center.setAppointments(center.getAppointments());
		
		return centerService.addVaccineCenter(center);
		
	}
	
	@PutMapping("/update")
	public VaccinationCenter updatVaccinationCenter( @Valid @RequestBody VaccinationCenter center){
		
		return centerService.updateVaccineCenter(center);
		
	}
	
	@DeleteMapping("/delet/{code}")
	public VaccinationCenter delVaccinationCenter( @PathVariable("code") Integer code) {
		
		VaccinationCenter vcenter = centerService.getVaccineCenter(code);
		
		return centerService.deleteVaccineCenter(vcenter);
		
	}
	
	@GetMapping("/findByCode/{code}")
	public VaccinationCenter getVaccinationCenter(@PathVariable("code") Integer code) {
		
		return centerService.getVaccineCenter(code);
		
	}
	
	@GetMapping("findAll")
	public List<VaccinationCenter> getAllVaccinationCenters(){
		
		return centerService.getAllVaccineCenters();
		
	}
	
}
