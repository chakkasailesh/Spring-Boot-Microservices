package com.springboot.organizationservice.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {
	@NotBlank(message = "Organization Name can't be blank")
	private String organizationName;
	@NotBlank(message = "Organization Description can't be blank")
	private String organizationDescription;
	@NotBlank(message = "Organization Code can't be blank")
	private String organizationCode;
	private LocalDateTime createdDate;
}
