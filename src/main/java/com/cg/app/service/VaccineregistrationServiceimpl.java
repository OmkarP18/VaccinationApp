package com.cg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.exception.VaccineException;
import com.cg.app.exception.VaccineRegistrationException;
import com.cg.app.model.Member;
import com.cg.app.model.Vaccine;
import com.cg.app.model.VaccineRegistration;
import com.cg.app.repository.VaccineRegistrationRepository;
@Service
public class VaccineregistrationServiceimpl  implements VaccineRegistrationService {
	
	@Autowired
	private VaccineRegistrationRepository vaccineregisterrepo;

	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg) {
		return vaccineregisterrepo.save(reg);
		
	}

	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration reg) throws VaccineRegistrationException {
		
		if(vaccineregisterrepo.existsById(reg.getMobileno()))
			return vaccineregisterrepo.save(reg);
		
		throw new VaccineRegistrationException("invalid mobileNO TO UPDATE" );
		
	}

	@Override
	public boolean deleteVaccineRegistration(VaccineRegistration reg) throws VaccineRegistrationException {
		if(vaccineregisterrepo.existsById(reg.getMobileno())) {
			vaccineregisterrepo.delete(reg);
			 return true;
		}
			
		throw new VaccineRegistrationException("invalid vaccine registered data");
		
	}

	@Override
	public VaccineRegistration getVaccineRegistration(long mobileno)throws VaccineRegistrationException {
		VaccineRegistration vaccineregister=vaccineregisterrepo.findByMobileno(mobileno);
		if(vaccineregister!=null)
			return vaccineregister;
		throw new VaccineRegistrationException("invalid vaccine registered data");
		
	}

	@Override
	public List<Member> getAllMember(long mobileno)throws VaccineRegistrationException {
		List<Member> member=(List<Member>) vaccineregisterrepo.findByMobileno(mobileno);

		
		if(member.size() >0)
			return member;
		

		throw new VaccineRegistrationException("invalid vaccine registered data");
	}

	@Override
	public List<VaccineRegistration> getAllVaccineRegistrations() throws VaccineRegistrationException{
		
List<VaccineRegistration> vaccinereg= vaccineregisterrepo.findAll();
		
		if(vaccinereg.size() >0)
			return vaccinereg;
		
		throw new VaccineRegistrationException("invalid vaccine registered data");
					
		}

}
