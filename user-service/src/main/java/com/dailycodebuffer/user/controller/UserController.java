package com.dailycodebuffer.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.user.entity.Users;
import com.dailycodebuffer.user.service.UserService;
import com.dailycodebuffer.user.vo.Response;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	
	@PostMapping("/")
	public Users save(@RequestBody Users user) {
		return service.save(user);
	}
	
	@GetMapping("/{id}")
	public Users findUserById(@PathVariable("id") Long id) {
		return service.findUserById(id);
	}
	
	@GetMapping("/details/{id}")
	public Response findUserDetailsById(@PathVariable("id") Long id) {
		return service.findUserDetailsById(id);
	}
}
