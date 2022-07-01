package com.cg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.exception.MemberException;
import com.cg.app.exception.VaccineException;
import com.cg.app.model.Member;
import com.cg.app.model.Vaccine;
import com.cg.app.repository.VaccineRepository;
@Service
public class VaccineServiceimpl implements VaccineService{
	@Autowired
	 private VaccineRepository vaccinerepo;

	@Override
	public Vaccine addVaccine(Vaccine vaccine) {
		
		return vaccinerepo.save(vaccine);
		
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine)  throws VaccineException{

		if(vaccinerepo.existsById(vaccine.getVaccineId()))
			return vaccinerepo.save(vaccine);
		
		throw new VaccineException("invalid vaccine data");
		
	}

	@Override
	public boolean deleteVaccine(Vaccine vaccine)throws VaccineException  {
		if(vaccinerepo.existsById(vaccine.getVaccineId())) {
			 vaccinerepo.delete(vaccine);
			 return true;
		}
			
		throw new VaccineException("invalid vaccine data");
		
	}

	@Override
	public Vaccine getVaccineByName(String vaccineName)throws VaccineException {
	 Vaccine vaccine=vaccinerepo.findByVaccnineName(vaccineName);
	 if(vaccine!=null)
		 return vaccine;
	 else
		 throw new VaccineException("invalid vaccine data");
		 
			
	}

	@Override
	public Vaccine getVaccineById(int vaccineId)throws VaccineException {
		Vaccine vaccine=vaccinerepo.findByVaccineId(vaccineId);
		 if(vaccine!=null)
			 return vaccine;
		 else
			 throw new VaccineException("invalid vaccine data");
			 
	}

	@Override
	public List<Vaccine> getAllVaccine()throws VaccineException {
List<Vaccine> vaccine= vaccinerepo.findAll();
		
		if(vaccine.size() >0)
			return vaccine;
		
		 throw new VaccineException("invalid vaccine data");
					
	}

}
