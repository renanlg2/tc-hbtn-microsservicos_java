package com.example.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket calculatorApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.calculator"))
                .paths(regex("/calculator.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        Contact contact = new Contact("Renan Lima", "https://github.com/renanlg2", "nanlima94@gmail.com");


        ApiInfo apiInfo = new ApiInfo(
                "Calculator API Rest",
                "API Rest for Calculator Operations",
                "1.0",
                "Termos of Service",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org",
                new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }


}
