package com.validation.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.validation.entities.User;


public interface ValidationService {
List<User> getAllUsers();
	
	void saveUser(User user);
	

	
	
}

