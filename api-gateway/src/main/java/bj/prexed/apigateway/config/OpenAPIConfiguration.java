package bj.prexed.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Component
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI gateWayOpenApi() {
        return new OpenAPI().info(new Info().title("Application Microservices APIs ")
                .description("Documentation for all the Microservices in Application")
                .version("v1.0.0")
                .contact(new Contact()
                        .name("Application Development Team")
                        .email("devspring2022@gmail.com")));
    }
}