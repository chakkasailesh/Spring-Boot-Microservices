package com.springboot.departmentservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service", 
				description = "REST APIs of Department Service", 
				version = "v1.0", 
				contact = @Contact(name = "Sailesh", email = "chakkasailesh444@gmail.com"),
				license = @License(
						name = "Apache 2.0",
						url = "https://spring.io/"
				)
		),
		externalDocs = @ExternalDocumentation(
			description = "Department Service doc",
			url = "https://spring.io/"
		)
)
@SpringBootApplication
public class DepartmentServiceApplication {
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
