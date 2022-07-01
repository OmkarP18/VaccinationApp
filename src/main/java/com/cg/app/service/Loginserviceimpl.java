package com.cg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.exception.RegistrationException;
import com.cg.app.exception.UnauthourizedException;
import com.cg.app.model.User;
import com.cg.app.repository.LoginRepository;
@Service
public class Loginserviceimpl implements LoginService{
	@Autowired
	private LoginRepository loginRepo;
	

	@Override
	public User doValidate(User user) throws UnauthourizedException {
		user=loginRepo.findByUsernameAndPasswordAndRole(user.getUsername(), user.getPassword(),user.getRole());
		
		if(user == null)
			throw new UnauthourizedException("Invalid UserName or password");
			
		return user;
			
	}

	@Override
	public User doRegister(User user) throws RegistrationException {
boolean isAvailable = isUserAvailable(user.getUsername());
		
		if(isAvailable)
			throw new RegistrationException("User is already present..");
		
		
		return loginRepo.save(user);
		
	}

	@Override
	public boolean isUserAvailable(String username) {
User user= loginRepo.findByUsername(username);
		
		if(user != null)
			return true;
		
		return false;
		
		
	}

}
