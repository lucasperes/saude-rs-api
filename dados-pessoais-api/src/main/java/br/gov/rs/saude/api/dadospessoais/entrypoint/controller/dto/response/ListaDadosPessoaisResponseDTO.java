package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.dto.DadosPessoalDTO;
import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DTO Request para listar os dados pessoais de usuarios
 */
@Getter @Setter
public class ListaDadosPessoaisResponseDTO extends AbstractDTOBase {

	private static final long serialVersionUID = 492088532163215285L;
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long usuarioId;
	
	@JsonProperty(access = Access.READ_ONLY)
	private DadosPessoalDTO dadosPessoal;
	
	@JsonProperty(access = Access.READ_ONLY)
	private Integer perfilId;
	@JsonProperty(access = Access.READ_ONLY)
	private String perfilNome;

}
