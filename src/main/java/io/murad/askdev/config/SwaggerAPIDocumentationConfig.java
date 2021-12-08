package io.murad.askdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerAPIDocumentationConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Ask Developer REST-API",
                "Ask Developer In Bangla Language",
                "1.0",
                "Free to use",
                new Contact("Md Murad Hossain", "https://github.com/mdmuradhossain", "murad.hossain.cse@ulab.edu.bd"),
                "API License",
                "https://github.com/mdmuradhossain",
                Collections.emptyList()
        );
    }


}
