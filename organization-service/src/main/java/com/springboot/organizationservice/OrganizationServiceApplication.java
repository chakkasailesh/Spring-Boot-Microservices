package com.springboot.organizationservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Organization Service", description = "REST APIs of Organization Service", version = "v1.0", contact = @Contact(name = "Sailesh", email = "chakkasailesh444@gmail.com"), license = @License(name = "Apache 2.0", url = "https://spring.io/")), externalDocs = @ExternalDocumentation(description = "Organization Service doc", url = "https://spring.io/"))
public class OrganizationServiceApplication {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
