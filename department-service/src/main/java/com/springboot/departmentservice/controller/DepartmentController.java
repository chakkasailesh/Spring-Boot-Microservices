package com.springboot.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.departmentservice.dto.DepartmentDTO;
import com.springboot.departmentservice.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@GetMapping
	public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
		return ResponseEntity.ok(departmentService.getAllDepartmens());
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) {
//		return ResponseEntity.ok(departmentService.getDepartmentById(id));
//	}

	@GetMapping("/{code}")
	public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable String code) {
		return ResponseEntity.ok(departmentService.getDepartmentByCode(code));
	}

	@PostMapping
	public ResponseEntity<DepartmentDTO> saveDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
		return new ResponseEntity<>(departmentService.saveDepartment(departmentDTO), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return ResponseEntity.ok("Deleted department with id: " + id);
	}
}
