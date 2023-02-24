package com.dailycodebuffer.department.repo;

import org.springframework.stereotype.Repository;

import com.dailycodebuffer.department.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
