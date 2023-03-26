package com.springboot.employeeservice.service;

import com.springboot.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO getEmployeeById(Long id);
}
