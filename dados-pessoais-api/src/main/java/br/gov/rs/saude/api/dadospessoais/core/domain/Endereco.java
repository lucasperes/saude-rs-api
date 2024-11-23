package br.gov.rs.saude.api.dadospessoais.core.domain;

import lombok.Data;

@Data
public class Endereco {
	
	private Long id;
	private String cep;
	private Cidade cidade;
	private String logradouro;
	private String bairro;
	private String complemento;

}
