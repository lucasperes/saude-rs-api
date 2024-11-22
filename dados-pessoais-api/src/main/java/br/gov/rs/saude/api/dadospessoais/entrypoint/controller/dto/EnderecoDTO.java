package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.EnderecoEntity;
import br.gov.rs.saude.api.saude.api.core.domain.entity.AbstractEntityBase;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DTO ModelMapper para {@link EnderecoEntity}
 */
@Getter @Setter
public class EnderecoDTO extends AbstractEntityBase<Long> {
	
	private static final long serialVersionUID = -8958206681131021332L;
	
	private Long id;
	
	@NotBlank
	private String cep;
	
	@NotNull
	private Integer cidadeId;
	@JsonProperty(access = Access.READ_ONLY)
	private String cidadeNome;
	@JsonProperty(access = Access.READ_ONLY)
	private String cidadeUf;
	
	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String bairro;
	
	private String complemento;

}
