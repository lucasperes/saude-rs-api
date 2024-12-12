package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.response;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.EnderecoEntity;
import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DTO ModelMapper para {@link EnderecoEntity}
 */
@Getter @Setter
public class EnderecoResponse extends AbstractDTOBase {
	
	private static final long serialVersionUID = -8958206681131021332L;
	
	private Long id;
	private String cep;
	private String nomeMunicipio;
	private String logradouro;
	private String bairro;
	private String uf;
	private String complemento;

}
