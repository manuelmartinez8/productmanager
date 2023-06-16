package com.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class OpenAPIConfig {

    @Value("${bezkoder.openapi.dev-url}")
    private String localUrl;

    @Bean
    public OpenAPI openAPIProject(){

        Server localServer = new Server();
        localServer.setUrl(localUrl);
        localServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("manuelon@hotmail.com");
        contact .setName("Manuelon");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
    Info info = new Info()
            .title("Project Manager System Api")
            .version("1.0")
            .contact(contact)
            .description("Esto es una descripcion del sistema desarrollado con SpringBoot y Thymeleaf")
            .license(mitLicense);

    return new OpenAPI().info(info).servers(List.of(localServer,localServer));

    }
}
