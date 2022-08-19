package com.shoppinglist.errand.helper;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;


public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Shopper Application API")
                        .description("This is my first project building from scratch")
                        .termsOfService("terms")
                        .license(new License().name("GNU"))
                        .version("1.0"));
    }
}
