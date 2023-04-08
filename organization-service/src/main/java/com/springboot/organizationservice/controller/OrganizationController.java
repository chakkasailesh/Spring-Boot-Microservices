package com.springboot.organizationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.organizationservice.dto.OrganizationDTO;
import com.springboot.organizationservice.service.OrganizationService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/organizations")
public class OrganizationController {
	@Autowired
	OrganizationService organizationService;

	@PostMapping
	public ResponseEntity<OrganizationDTO> saveOrganization(@Valid @RequestBody OrganizationDTO organizationDTO) {
		return new ResponseEntity<>(organizationService.saveOrganization(organizationDTO), HttpStatus.OK);
	}

	@GetMapping("/{code}")
	public ResponseEntity<OrganizationDTO> getOrganizationByCode(@PathVariable String code) {
		return ResponseEntity.ok(organizationService.getOrganizationByCode(code));
	}
}
