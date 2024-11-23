package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.response;

import java.util.Set;

import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DTO Response para listar os dados pessoais de usuarios
 */
@Getter @Setter
public class ListaDadosPessoaisResponse extends AbstractDTOBase {

	private static final long serialVersionUID = 492088532163215285L;
	
	private Long usuarioId;
	private DadosPessoalResponse dadosPessoal;
	private Set<PerfilResponse> perfis;
	private EntityStatusEnum status;
	
}