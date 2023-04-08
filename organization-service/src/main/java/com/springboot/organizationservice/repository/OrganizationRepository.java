package com.springboot.organizationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.organizationservice.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	public Optional<Organization> findByOrganizationCode(String organizationCode);
}
