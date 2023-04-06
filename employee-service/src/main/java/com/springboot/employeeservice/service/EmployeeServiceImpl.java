package com.springboot.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.springboot.employeeservice.dto.APIResponseDTO;
import com.springboot.employeeservice.dto.DepartmentDTO;
import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.entity.Employee;
import com.springboot.employeeservice.exception.ResourceNotFoundException;
import com.springboot.employeeservice.repository.EmployeeRepository;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ModelMapper mapper;

//	@Autowired
//	private RestTemplate restTemplate;
//
	@Autowired
	private WebClient webClient;

//	@Autowired
//	private APIClient apiClient;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		Employee employee = mapper.map(employeeDTO, Employee.class);
		return mapper.map(employeeRepository.save(employee), EmployeeDTO.class);
	}

//	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public APIResponseDTO getEmployeeById(Long id) {
		LOGGER.info("inside getEmployeeById method");
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", String.valueOf(id)));
//		DepartmentDTO departmentDTO = restTemplate
//		.getForEntity("http://localhost:8080/api/departments/" + employeeDTO.getDepartmentCode(),
//				DepartmentDTO.class)
//		.getBody();
		DepartmentDTO departmentDTO = webClient.get()
				.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDTO.class).block();
//		DepartmentDTO departmentDTO = apiClient.getDepartment(employee.getDepartmentCode());
		return new APIResponseDTO(mapper.map(employee, EmployeeDTO.class), departmentDTO);
	}

	public APIResponseDTO getDefaultDepartment(Long id, Exception exception) {
		LOGGER.info("inside getDefaultDepartment method");
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", String.valueOf(id)));
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setCode("D01");
		departmentDTO.setDescription("Default Department");
		departmentDTO.setName("Default");
		return new APIResponseDTO(mapper.map(employee, EmployeeDTO.class), departmentDTO);
	}

}
