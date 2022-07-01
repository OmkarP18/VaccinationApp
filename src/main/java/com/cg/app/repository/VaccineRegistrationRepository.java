package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.app.model.VaccineRegistration;

public interface VaccineRegistrationRepository extends JpaRepository<VaccineRegistration,Long>{
	
	public VaccineRegistration findByMobileno(long mobileno);
}
