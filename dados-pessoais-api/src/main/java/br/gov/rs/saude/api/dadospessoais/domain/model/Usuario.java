package br.gov.rs.saude.api.dadospessoais.domain.model;

import lombok.Data;

@Data
public class Usuario {

	private Long id;
	private DadosPessoal dadosPessoal;
	private Perfil perfil;
	
}
