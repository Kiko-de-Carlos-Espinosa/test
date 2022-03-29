package com.kiko_de_carlos.Test.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "existingApis",
        version = "1.0"
    )
)
public class SwaggerConfig {                                    
   
}