package com.hermes.recruitment.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(TypeResolver typeResolver)
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .alternateTypeRules(
                       AlternateTypeRules.newRule(typeResolver.resolve(ArrayList.class, LocalDateTime.class), typeResolver.resolve(List.class, java.util.Date.class)))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hermes.recruitment.controller"))
                .build()
                .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
                .useDefaultResponseMessages(false)
                .apiInfo(buildApiInfo());
    }
    private ApiInfo buildApiInfo()
    {
        return new ApiInfoBuilder()
                .title("Hermes Recruitment Api")
                .description("test")
                .version("1.0")
                .license("Licenced Under Hermes")
                .build();
    }
}
