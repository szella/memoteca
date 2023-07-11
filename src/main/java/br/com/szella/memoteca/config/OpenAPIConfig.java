package br.com.szella.memoteca.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Value("${app.name}")
    private String name;

    @Value("${app.description}")
    private String description;

    @Value("${app.version}")
    private String version;

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title(name)
                .version(version)
                .description(description);

        return new OpenAPI().info(info);
    }
}
