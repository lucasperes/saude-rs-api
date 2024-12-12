package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.DadosPessoaisEntity;
import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.SexoEnum;
import br.gov.rs.saude.api.saude.api.core.utils.ConstantsUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe DTO ModelMapper para {@link DadosPessoaisEntity}
 */
@Getter @Setter
public class DadosPessoaisResponse extends AbstractDTOBase {

	private static final long serialVersionUID = -1615944040192306132L;
	
	private Long id;
	private String nomeCompleto;
	private String nomeSocial;
	@JsonFormat(pattern = ConstantsUtils.Pattern.DATE_BRAZILIAN)
	private LocalDate dataNascimento;
	private SexoEnum sexo;
	private String cpf;
	private String rg;
	private String cns;
	private String nomeMaeCompleto;
	private String nomePaiCompleto;
	private EnderecoResponse endereco;
	private String telefone;

}
