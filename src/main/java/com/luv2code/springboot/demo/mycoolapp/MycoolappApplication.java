package com.luv2code.springboot.demo.mycoolapp;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/*"))
				.apis(RequestHandlerSelectors.basePackage("com.luv2code.springboot"))
				.build()
				.apiInfo(apiDetails());
	}
	
	
	private ApiInfo apiDetails() {
		return new ApiInfo("Student Activity API",
				"Sample API documentation",
				"2.0",
				"Test documentation",
				new springfox.documentation.service.Contact("Sarthak", "https://accenture.com", "sarthak.taru07@gmail.com"),
				"API License",
				"https://accenture.com",
				Collections.emptyList());
	}
}
