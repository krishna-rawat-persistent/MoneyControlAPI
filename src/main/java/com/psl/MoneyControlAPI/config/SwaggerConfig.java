package com.psl.MoneyControlAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30).apiInfo(getInfo()).select().apis(RequestHandlerSelectors.basePackage("com.psl.MoneyControlAPI")).paths(PathSelectors.any()).build();
    }

    private ApiInfo getInfo() {
        return new ApiInfoBuilder().title("MoneyViewAPI Documentation").description("This is a Backend API for get top stock for given stocks type.").contact(new Contact("Persistent Systems","https://www.persistent.com/",null)).version("1.0").license("Apache 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0").build();
    }
}
