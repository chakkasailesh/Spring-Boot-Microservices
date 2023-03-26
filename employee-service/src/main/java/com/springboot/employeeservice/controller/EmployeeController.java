package com.springboot.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDTO> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		return new ResponseEntity<>(employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
}
