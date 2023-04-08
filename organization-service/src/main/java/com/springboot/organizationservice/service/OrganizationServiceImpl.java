package com.springboot.organizationservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.organizationservice.dto.OrganizationDTO;
import com.springboot.organizationservice.entity.Organization;
import com.springboot.organizationservice.exception.ResourceNotFoundException;
import com.springboot.organizationservice.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {
		Organization organization = mapper.map(organizationDTO, Organization.class);
		return mapper.map(organizationRepository.save(organization), OrganizationDTO.class);
	}

	@Override
	public OrganizationDTO getOrganizationByCode(String code) {
		Organization organization = organizationRepository.findByOrganizationCode(code)
				.orElseThrow(() -> new ResourceNotFoundException("Organization", "organizationCode", code));
		return mapper.map(organization, OrganizationDTO.class);
	}
}
