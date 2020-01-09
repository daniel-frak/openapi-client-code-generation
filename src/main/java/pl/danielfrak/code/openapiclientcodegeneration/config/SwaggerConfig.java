package pl.danielfrak.code.openapiclientcodegeneration.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(
        title = "Planet management API",
        description = "Allows for managing all planets in the galaxy"
))
@Configuration
public class SwaggerConfig {
}
