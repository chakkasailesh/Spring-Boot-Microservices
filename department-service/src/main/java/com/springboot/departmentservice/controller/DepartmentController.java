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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Department Service - DepartmentController", description = "Department Controller exposes REST APIs for DEPARTMENT-SERVICE")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@Operation(summary = "Get Departments REST API", description = "API to get all departments")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
	@GetMapping
	public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
		return ResponseEntity.ok(departmentService.getAllDepartmens());
	}

	// @GetMapping("/{id}")
	// public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long
	// id) {
	// return ResponseEntity.ok(departmentService.getDepartmentById(id));
	// }

	@GetMapping("/{code}")
	public ResponseEntity<DepartmentDTO> getDepartmentByCode(
			@PathVariable String code) {
		return ResponseEntity.ok(departmentService.getDepartmentByCode(code));
	}

	@PostMapping
	public ResponseEntity<DepartmentDTO> saveDepartment(
			@Valid @RequestBody DepartmentDTO departmentDTO) {
		return new ResponseEntity<>(
				departmentService.saveDepartment(departmentDTO),
				HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return ResponseEntity.ok("Deleted department with id: " + id);
	}
}
