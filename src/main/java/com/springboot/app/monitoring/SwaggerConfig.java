package com.springboot.app.monitoring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;
import com.google.common.base.Predicate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

@Bean
public Docket api() {
return new Docket(DocumentationType.SWAGGER_2)
.useDefaultResponseMessages(false)
.select()
.apis(RequestHandlerSelectors.any())
.apis(RequestHandlerSelectors.basePackage("com.springboot.springboot.appmonitoring.controller"))
.paths(paths()).build()
.apiInfo(apiInfo());
}

private ApiInfo apiInfo() {
return new ApiInfoBuilder()
.title("SPRING LABS")
.version("1.0")
.termsOfServiceUrl("http://intellitech.pro/")
.build();
}

@SuppressWarnings("unchecked")
private Predicate paths() {
return or(
regex("/users.*"),
regex("/role.*"),
regex("/process.*"),
regex("/annulation.*"),
regex("/recyclage.*"),
regex("/statistique.*"),
regex("/batch.*"),
regex("/login.*"));

}
}