package com.dailycodebuffer.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.repo.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department save(Department department) {
		
		log.info("DepartmentService-save-"+department);
		return departmentRepository.save(department);
		//return null;
	}

	public Department findById(Long departmentId) {
		log.info("DepartmentService-findById-id="+departmentId);
		Department departmen= departmentRepository.getById(departmentId);
		log.info("DepartmentService-findById-id="+departmentId+"|output="+departmen);
		return departmen;
	}
}
