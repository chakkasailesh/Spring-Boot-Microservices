package com.springboot.departmentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.departmentservice.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Optional<Department> findByCode(String code);
}
