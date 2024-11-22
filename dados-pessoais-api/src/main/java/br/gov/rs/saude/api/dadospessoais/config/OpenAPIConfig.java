package br.gov.rs.saude.api.dadospessoais.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


/**
 * Classe Config para definir as propriedades do Swagger
 *
 */
@Configuration
public class OpenAPIConfig {
	
	@Bean
	OpenAPI openAPI() {
		Info info = new Info()
				.title("Secretaria de Saúde do Estado do Rio Grande do Sul API")
				.version("1.0.0")
				.description("Documentação oficial da API de Dados Pessoais da Secretaria de Saúde do Estado do Rio Grande do Sul");
		OpenAPI api = new OpenAPI()
				.info(info);
		return api;
	}

}
