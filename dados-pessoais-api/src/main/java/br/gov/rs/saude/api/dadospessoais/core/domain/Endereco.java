package br.gov.rs.saude.api.dadospessoais.core.domain;

import lombok.Data;

@Data
public class Endereco {

	private Long id;
	private String cep;
	private String nomeMunicipio;
	private String logradouro;
	private String bairro;
	private String uf;
	private String complemento;

}
