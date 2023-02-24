package com.dailycodebuffer.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.user.entity.Users;
import com.dailycodebuffer.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public Users save(Users user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	public Users findUserById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	
	
}
