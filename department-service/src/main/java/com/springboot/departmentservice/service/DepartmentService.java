package com.springboot.departmentservice.service;

import java.util.List;

import com.springboot.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {
	DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

	DepartmentDTO getDepartmentById(Long id);

	DepartmentDTO getDepartmentByCode(String code);

	List<DepartmentDTO> getAllDepartmens();

	void deleteDepartment(Long id);
}
