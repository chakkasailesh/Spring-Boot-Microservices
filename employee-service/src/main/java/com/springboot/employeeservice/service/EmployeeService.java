package com.springboot.employeeservice.service;

import com.springboot.employeeservice.dto.APIResponseDTO;
import com.springboot.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

	APIResponseDTO getEmployeeById(Long id);
}
