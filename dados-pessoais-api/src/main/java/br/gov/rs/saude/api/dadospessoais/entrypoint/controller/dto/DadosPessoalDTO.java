package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.DadosPessoalEntity;
import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.SexoEnum;
import br.gov.rs.saude.api.saude.api.core.utils.ConstantsUtils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DTO ModelMapper para {@link DadosPessoalEntity}
 */
@Getter @Setter
public class DadosPessoalDTO extends AbstractDTOBase {

	private static final long serialVersionUID = -1615944040192306132L;
	
	private Long id;
	
	@NotBlank
	private String nomeCompleto;
	
	private String nomeSocial;
	
	@NotNull
	@JsonFormat(pattern = ConstantsUtils.Pattern.DATE_BRAZILIAN)
	private LocalDate dataNascimento;
	
	@NotNull
	private SexoEnum sexo;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String rg;
	
	@NotBlank
	private String cns;
	
	@NotBlank
	private String nomeMaeCompleto;
	
	private String nomePaiCompleto;
	
	@NotNull
	private EnderecoDTO endereco;
	
	@NotBlank
	private String telefone;

}
