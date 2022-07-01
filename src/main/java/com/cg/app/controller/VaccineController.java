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
import com.cg.app.service.VaccineService;

@RestController
@RequestMapping("/vaccine")
@CrossOrigin(origins = "*")
public class VaccineController {
	
	
	@Autowired
	private VaccineService vaccineservice;
	
	@PostMapping("/addvaccine")
	public Vaccine addVaccinehandler(@Valid @RequestBody Vaccine vaccine) {
		Vaccine newvaccine=new Vaccine();
		newvaccine.setVaccnineName(vaccine.getVaccnineName());
		newvaccine.setDescription(vaccine.getDescription());
		return vaccineservice.addVaccine(newvaccine);
	}
	
	@PutMapping("/updatevaccine")
	public Vaccine updateVaccine(@Valid @RequestBody Vaccine vaccine) {
		return vaccineservice.updateVaccine(vaccine);
		
	}
	@DeleteMapping("/deletevaccine")
		public boolean deleteVaccine(@Valid @RequestBody Vaccine vaccine) {
			
			Vaccine deletevaccine= vaccineservice.getVaccineByName(vaccine.getVaccnineName());
			
			return vaccineservice.deleteVaccine(deletevaccine);
		
	}
	@GetMapping("/findbyvaccinename/{vaccnineName}")
	public Vaccine getVaccineByName(@PathVariable ("vaccnineName")String vaccineName) {
		return vaccineservice.getVaccineByName(vaccineName);
		
	}
	@GetMapping("/findbyvaccineid/{vaccineId}")
	public Vaccine getVaccineById(@PathVariable("vaccineId")int vaccineId) {
		return vaccineservice.getVaccineById(vaccineId);
	}
	@GetMapping("/findallvaccine")
	public List<Vaccine> getAllVaccine(){
		return vaccineservice.getAllVaccine();
	}

}
