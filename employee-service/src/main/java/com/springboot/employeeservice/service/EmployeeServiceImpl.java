package com.springboot.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.entity.Employee;
import com.springboot.employeeservice.exception.ResourceNotFoundException;
import com.springboot.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		Employee employee = mapper.map(employeeDTO, Employee.class);
		return mapper.map(employeeRepository.save(employee), EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", String.valueOf(id)));
		return mapper.map(employee, EmployeeDTO.class);
	}

}
