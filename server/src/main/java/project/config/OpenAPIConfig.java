package project.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

  private final String devUrl = "https://prod:8080";

  private final String prodUrl = "http://localhost:8080";

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");

    Server prodServer = new Server();
    prodServer.setUrl(prodUrl);
    prodServer.setDescription("Server URL in Production environment");

    Contact contact = new Contact();
    contact.setEmail("Email");
    contact.setName("Name");
    contact.setUrl("URL");

    Info info = new Info()
        .title("Project API")
        .version("1.0")
        .contact(contact)
        .description("This API exposes endpoints to manage tutorials.");

    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
  }
}
