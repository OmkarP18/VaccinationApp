package com.cg.app.service;

import com.cg.app.exception.RegistrationException;
import com.cg.app.exception.UnauthourizedException;
import com.cg.app.model.User;

public interface LoginService {
	public User doValidate(User user)throws  UnauthourizedException;
	public User doRegister(User user)throws RegistrationException;
	public boolean isUserAvailable(String username);
}
