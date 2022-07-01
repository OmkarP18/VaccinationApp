package com.cg.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.exception.MemberException;
import com.cg.app.exception.VaccineCenterException;
import com.cg.app.model.VaccinationCenter;
import com.cg.app.repository.MemberRepository;
import com.cg.app.repository.VaccinationCenterRepository;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService{

	@Autowired
	private VaccinationCenterRepository centerRepo;

	@Override
	public VaccinationCenter addVaccineCenter(VaccinationCenter center) {

		return centerRepo.save(center);
	}

	@Override
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center) throws VaccineCenterException {

		if(centerRepo.existsById(center.getCode()))
			return centerRepo.save(center);

		throw new VaccineCenterException("Invalid VaccineCenter Data");
	}

	@Override
	public VaccinationCenter deleteVaccineCenter(VaccinationCenter center) throws VaccineCenterException {

		if(centerRepo.existsById(center.getCode())) {
			centerRepo.delete(center);
			return center;
		}


		throw new VaccineCenterException("Invalid VaccineCenter Data");	
	}

	@Override
	public VaccinationCenter getVaccineCenter(int centerid) throws VaccineCenterException {
		List<VaccinationCenter> centers = centerRepo.findAll();

		for(VaccinationCenter center : centers) {

			if(centerid == center.getCode())
				return center;
		}

		throw new MemberException("invalid Adhar Card Number...");
	}

	@Override
	public List<VaccinationCenter> getAllVaccineCenters() {
		
		List<VaccinationCenter> centers = centerRepo.findAll();

		if(centers.size() >0)
			return centers;

		throw new VaccineCenterException("No VaccineCenter Found");
	}

}
