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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.springboot.employeeservice.dto.APIResponseDTO;
import com.springboot.employeeservice.dto.DepartmentDTO;
import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient webClient;

	@PostMapping
	public ResponseEntity<EmployeeDTO> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		return new ResponseEntity<>(employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable Long id) {
		EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
//		DepartmentDTO departmentDTO = restTemplate
//				.getForEntity("http://localhost:8080/api/departments/" + employeeDTO.getDepartmentCode(),
//						DepartmentDTO.class)
//				.getBody();
		DepartmentDTO departmentDTO = webClient.get()
				.uri("http://localhost:8080/api/departments/" + employeeDTO.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDTO.class).block();
		return ResponseEntity.ok(new APIResponseDTO(employeeDTO, departmentDTO));
	}
}
