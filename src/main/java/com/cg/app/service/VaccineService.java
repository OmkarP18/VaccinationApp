package com.cg.app.service;

import java.util.List;

import com.cg.app.model.Vaccine;

public interface VaccineService {
	public Vaccine addVaccine(Vaccine vaccine);
	public Vaccine updateVaccine(Vaccine vaccine);
	public boolean deleteVaccine(Vaccine vaccine);
	public Vaccine getVaccineByName(String vaccineName);
	public Vaccine getVaccineById(int vaccineId);
	public List<Vaccine> getAllVaccine();
}
