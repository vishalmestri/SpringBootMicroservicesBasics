package com.dailycodebuffer.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.user.entity.Users;
import com.dailycodebuffer.user.repository.UserRepository;
import com.dailycodebuffer.user.vo.Department;
import com.dailycodebuffer.user.vo.Response;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;

	public Users save(Users user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	public Users findUserById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	public Response findUserDetailsById(Long id) {
		// TODO Auto-generated method stub
		
		Response response=new Response();
		
		Users user=repository.getById(id);
		response.setUser(user);
		
		Department department=	restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
	
		response.setDepartment(department);
		return response;
	}
	
	
}
