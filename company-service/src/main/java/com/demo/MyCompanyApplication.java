package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyCompanyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyCompanyApplication.class, args);
		System.out.println("Company app started..");
	}
	
	@Bean
	public Docket swaggerConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.paths(PathSelectors.ant("/api/v1.0/market/company/**"))
		    //.paths(RequestHandlerSelectors.basePackage("com.demo"))
			.build()
			.apiInfo(metadata())
			;
	}
	
	private ApiInfo metadata(){
		return new ApiInfoBuilder()
			.title("Welcome to company service")
			.description("Company service has all the company details")
			.version("4.2.8")
			.license("www.company_service.url")
			.contact(new Contact("Company Service", "company-service.page", "company-service@gmail.com"))
			.build();
	}

}
