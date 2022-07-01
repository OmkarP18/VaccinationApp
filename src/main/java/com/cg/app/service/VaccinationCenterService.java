package com.cg.app.service;

import java.util.List;

import com.cg.app.model.VaccinationCenter;

public interface VaccinationCenterService {
	public VaccinationCenter addVaccineCenter(VaccinationCenter center);
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center);
	public VaccinationCenter deleteVaccineCenter(VaccinationCenter center);
	public VaccinationCenter getVaccineCenter(int centerid);
	public List<VaccinationCenter> getAllVaccineCenters();
}
