package com.springboot.departmentservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.departmentservice.dto.DepartmentDTO;
import com.springboot.departmentservice.entity.Department;
import com.springboot.departmentservice.exception.ResourceNotFoundException;
import com.springboot.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
		Department department = mapper.map(departmentDTO, Department.class);
		return mapper.map(departmentRepository.save(department), DepartmentDTO.class);
	}

	@Override
	public List<DepartmentDTO> getAllDepartmens() {
		List<Department> departments = departmentRepository.findAll();
		List<DepartmentDTO> departmentDTOs = departments.stream()
				.map(department -> mapper.map(department, DepartmentDTO.class)).collect(Collectors.toList());
		return departmentDTOs;
	}

	@Override
	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public DepartmentDTO getDepartmentById(Long id) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "Id", String.valueOf(id)));
		return mapper.map(department, DepartmentDTO.class);
	}

	@Override
	public DepartmentDTO getDepartmentByCode(String code) {
		Department department = departmentRepository.findByCode(code)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "Code", code));
		return mapper.map(department, DepartmentDTO.class);
	}

}
