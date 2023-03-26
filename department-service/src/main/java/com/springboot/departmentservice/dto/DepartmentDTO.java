package com.springboot.departmentservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
	private Long id;
	@NotBlank(message = "Department Name can't be blank")
	private String name;
	@NotBlank(message = "Department Description can't be blank")
	private String description;
	@NotBlank(message = "Department Code can't be blank")
	private String code;
}
