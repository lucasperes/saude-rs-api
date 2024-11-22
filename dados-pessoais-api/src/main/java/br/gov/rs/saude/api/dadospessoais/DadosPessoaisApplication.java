package br.gov.rs.saude.api.dadospessoais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.gov.rs.saude.api.saude.api.core.config.AppConfig;

@SpringBootApplication
@Import({AppConfig.class})
public class DadosPessoaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DadosPessoaisApplication.class, args);
	}

}
