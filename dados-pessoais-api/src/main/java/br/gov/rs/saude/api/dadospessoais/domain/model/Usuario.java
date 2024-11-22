package br.gov.rs.saude.api.dadospessoais.domain.model;

import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;
import lombok.Data;

@Data
public class Usuario {

	private Long id;
	private DadosPessoal dadosPessoal;
	private Perfil perfil;
	private EntityStatusEnum status;
	
}
