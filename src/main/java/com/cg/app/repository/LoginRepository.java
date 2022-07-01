package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.app.model.User;

public interface LoginRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);

	public User findByUsernameAndPasswordAndRole(String username, String password, String role);

}
