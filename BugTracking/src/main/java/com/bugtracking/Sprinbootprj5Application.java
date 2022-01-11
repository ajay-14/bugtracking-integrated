package com.bugtracking;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Sprinbootprj5Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprinbootprj5Application.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.bugtracking.controller")).build()
				.apiInfo(new ApiInfo("SPRING WITH SWAGGER API", "API CREATION", "1.0", "Free to Use",
						new Contact("Bugtracking", "/api", "bugtracking@gmail.com"), "API licence", "/api",
						Collections.emptyList()));

	}

}
