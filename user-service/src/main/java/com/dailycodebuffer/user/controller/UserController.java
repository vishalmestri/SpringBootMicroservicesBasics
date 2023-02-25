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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

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
	@CircuitBreaker(name = DEPARTEMENT_SERVICE,fallbackMethod = "departmentServiceFallback")
	public Response findUserDetailsById(@PathVariable("id") Long id) {
		return service.findUserDetailsById(id);
	}
	
	
	private static final String DEPARTEMENT_SERVICE="DEPARTMENTSERVICE";
	public Response departmentServiceFallback(Exception e) {
		Response r=new Response();
		return r;
	}
}
