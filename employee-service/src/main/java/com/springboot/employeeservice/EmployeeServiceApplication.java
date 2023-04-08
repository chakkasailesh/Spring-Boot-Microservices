package com.springboot.employeeservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Employee Service", description = "REST APIs of Employee Service", version = "v1.0", contact = @Contact(name = "Sailesh", email = "chakkasailesh444@gmail.com"), license = @License(name = "Apache 2.0", url = "https://spring.io/")), externalDocs = @ExternalDocumentation(description = "Employee Service doc", url = "https://spring.io/"))
public class EmployeeServiceApplication {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
