package com.springboot.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeeservice.dto.APIResponseDTO;
import com.springboot.employeeservice.dto.DepartmentDTO;
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

//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Autowired
//	private WebClient webClient;

	@Autowired
	private APIClient apiClient;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		Employee employee = mapper.map(employeeDTO, Employee.class);
		return mapper.map(employeeRepository.save(employee), EmployeeDTO.class);
	}

	@Override
	public APIResponseDTO getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", String.valueOf(id)));
//		DepartmentDTO departmentDTO = restTemplate
//		.getForEntity("http://localhost:8080/api/departments/" + employeeDTO.getDepartmentCode(),
//				DepartmentDTO.class)
//		.getBody();
//		DepartmentDTO departmentDTO = webClient.get()
//				.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode()).retrieve()
//				.bodyToMono(DepartmentDTO.class).block();
		DepartmentDTO departmentDTO = apiClient.getDepartment(employee.getDepartmentCode());
		return new APIResponseDTO(mapper.map(employee, EmployeeDTO.class), departmentDTO);
	}

}
