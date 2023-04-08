package com.springboot.employeeservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	private Long id;
	@NotBlank(message = "Employee First Name can't be blank")
	private String firstName;
	@NotBlank(message = "Employee Last Name can't be blank")
	private String lastName;
	@NotBlank(message = "Employee Email can't be blank")
	@Email
	private String email;
	@NotBlank(message = "Department Code can't be blank")
	private String departmentCode;
	@NotBlank(message = "Organization Code can't be blank")
	private String organizationCode;
}
