package com.springboot.organizationservice.service;

import com.springboot.organizationservice.dto.OrganizationDTO;

public interface OrganizationService {
	OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);

	OrganizationDTO getOrganizationByCode(String code);
}
