package com.validation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.entities.User;
import com.validation.repository.ValidationRepository;

@Service
public class ValidationServiceImpl implements ValidationService{

	@Autowired
	private ValidationRepository repo;
	
	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public void saveUser(User user) {
		this.repo.save(user);
	}

	
}
