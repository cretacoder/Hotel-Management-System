package com.ajay.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@SpringBootApplication
public class HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Hotel Management API")
                .version("1.0")
                .description("API documentation for managing Hotel")
                .contact(new Contact()
                    .name("AJAY S")
                    .email("ajaycoder24@gmail.com"))
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                .termsOfService("http://swagger.io/terms/"))
            .servers(java.util.Arrays.asList(
                new Server().url("http://localhost:8080").description("Local Development Server"),
                new Server().url("https://your-production-url.com").description("Production Server")
            ));
    }

}
