package com.springboot.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DepartmentDTO model information")
public class DepartmentDTO {
	private Long id;
	@NotBlank(message = "Department Name can't be blank")
	private String name;
	@NotBlank(message = "Department Description can't be blank")
	private String description;
	@NotBlank(message = "Department Code can't be blank")
	private String code;
}
