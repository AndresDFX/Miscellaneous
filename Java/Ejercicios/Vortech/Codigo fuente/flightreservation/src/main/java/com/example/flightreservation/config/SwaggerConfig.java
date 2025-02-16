package com.example.flightreservation.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openAPI = new OpenAPI();
        openAPI.setOpenapi("3.0.1");
        
        openAPI.info(new Info()
                .title("Flight Reservation API")
                .version("1.0")
                .description("API para gestionar reservas de vuelos"));
        return openAPI;
    }
}
