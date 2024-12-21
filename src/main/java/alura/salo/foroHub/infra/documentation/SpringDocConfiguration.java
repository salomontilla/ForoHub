package alura.salo.foroHub.infra.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("Foro Hub RestAPI")
                        .description("REST API for forum management, developed with Java and Spring Boot. Implements authentication using JWT and uses Spring Security for endpoint protection, allowing user registration, post creation, and comments")
                        .contact(new Contact()
                                .name("Salomon Montilla Luna")
                                .email("salomontilla@outlook.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://alura.salo/foroHub/licence")));
    }
}
