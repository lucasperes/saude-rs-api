package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.DadosPessoaisEntity;
import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.SexoEnum;
import br.gov.rs.saude.api.saude.api.core.utils.ConstantsUtils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DTO ModelMapper para {@link DadosPessoaisEntity}
 */
@Getter @Setter
public class DadosPessoaisRequest extends AbstractDTOBase {

	private static final long serialVersionUID = -1615944040192306132L;
	
	@NotBlank
	@Size(max = 60)
	private String nomeCompleto;

	@Size(max = 60)
	private String nomeSocial;

	@NotNull
	@JsonFormat(pattern = ConstantsUtils.Pattern.DATE_BRAZILIAN)
	private LocalDate dataNascimento;

	@NotNull
	private SexoEnum sexo;

	@NotBlank
	@Size(max = 14)
	private String cpf;

	@NotBlank
	@Size(max = 15)
	private String rg;

	@NotBlank
	@Size(max = 15)
	private String cns;

	@NotBlank
	@Size(max = 60)
	private String nomeMaeCompleto;

	@Size(max = 60)
	private String nomePaiCompleto;

	@NotNull
	private EnderecoRequest endereco;

	@NotBlank
	@Size(max = 20)
	private String telefone;

}
