package com.springboot.employeeservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {
	private String organizationName;
	private String organizationDescription;
	private String organizationCode;
	private LocalDateTime createdDate;
}
