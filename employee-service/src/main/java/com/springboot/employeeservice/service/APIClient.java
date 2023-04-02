package com.springboot.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.employeeservice.dto.DepartmentDTO;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
	// Build get department rest api
	@GetMapping("api/departments/{departmentCode}")
	DepartmentDTO getDepartment(@PathVariable String departmentCode);
}