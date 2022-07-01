package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.app.model.VaccinationCenter;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {
	
}
