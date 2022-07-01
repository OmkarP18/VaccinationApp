package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.model.Vaccine;
@Repository 
public interface VaccineRepository extends JpaRepository<Vaccine, Integer>{
	public Vaccine findByVaccnineName(String vaccineName);
	public Vaccine findByVaccineId(Integer vaccineid);

}
