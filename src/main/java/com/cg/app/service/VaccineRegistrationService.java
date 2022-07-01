package com.cg.app.service;

import java.util.List;

import com.cg.app.model.Member;
import com.cg.app.model.VaccineRegistration;

public interface VaccineRegistrationService {
	public VaccineRegistration addVaccineRegistration (VaccineRegistration reg);
	public VaccineRegistration updateVaccineRegistration (VaccineRegistration reg);
	public boolean deleteVaccineRegistration (VaccineRegistration reg);
	public VaccineRegistration getVaccineRegistration (long mobileno);
	public List<Member> getAllMember(long mobileno);
	public List<VaccineRegistration> getAllVaccineRegistrations();
}
