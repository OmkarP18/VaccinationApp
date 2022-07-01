package com.cg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.model.User;
import com.cg.app.service.Loginserviceimpl;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {
	@Autowired
	Loginserviceimpl loginService;
	

	@PostMapping("/authenticate")
	public User validate(@RequestBody User user) {
	
		return loginService.doValidate(user);
	
	}
	
	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) {
		
	  return loginService.doRegister(user);
		
	}
	
	@GetMapping("/checkUser/{username}")
	public boolean isUserAvailable(@PathVariable String username) {
		
		 return loginService.isUserAvailable(username);
		
	}
	


}
