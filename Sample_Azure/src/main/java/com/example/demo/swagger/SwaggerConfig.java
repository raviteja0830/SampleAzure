package com.example.demo.swagger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")).paths(PathSelectors.any()).build()
				.ignoredParameterTypes(Principal.class).directModelSubstitute(LocalDateTime.class, String.class)
				.directModelSubstitute(LocalDate.class, String.class)
				.directModelSubstitute(LocalTime.class, String.class)
				.globalOperationParameters(
				        Arrays.asList(new ParameterBuilder()
				            .name("Accept-language")
				            .description("language")
				            .modelRef(new ModelRef("string"))
				            .parameterType("header")
				            .required(false)
				            .build()));

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SBD Fetch Services").description("SBD Fetch Services").build();
	}

}
