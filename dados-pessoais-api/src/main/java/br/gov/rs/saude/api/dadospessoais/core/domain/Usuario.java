package br.gov.rs.saude.api.dadospessoais.core.domain;

import java.util.Set;

import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;
import lombok.Data;

@Data
public class Usuario {

	private Long id;
	private DadosPessoais dadosPessoais;
	private Perfil perfil;
	private EntityStatusEnum status;
	private Set<Perfil> perfis;
	
}
