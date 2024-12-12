package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.EnderecoEntity;
import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DTO ModelMapper para {@link EnderecoEntity}
 */
@Getter @Setter
public class EnderecoRequest extends AbstractDTOBase {
	
	private static final long serialVersionUID = -8958206681131021332L;
	
	private Long id;

	@NotBlank
	@Size(max = 8)
	private String cep;

	@NotBlank
	@Size(max = 300)
	private String nomeMunicipio;

	@NotBlank
	@Size(max = 2)
	private String uf;

	@NotBlank
	@Size(max = 120)
	private String logradouro;

	@NotBlank
	@Size(max = 60)
	private String bairro;

	private String complemento;

}
