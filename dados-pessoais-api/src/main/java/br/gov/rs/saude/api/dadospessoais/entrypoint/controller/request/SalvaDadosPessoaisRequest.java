package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.request;

import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DTO Request para salvar os dados pessoais de um usuario
 */
@Getter @Setter
public class SalvaDadosPessoaisRequest extends AbstractDTOBase {

	private static final long serialVersionUID = 492088532163215285L;
	
	private Long usuarioId;
	
	@Valid
	@NotNull
	private DadosPessoalRequest dadosPessoal;

}
