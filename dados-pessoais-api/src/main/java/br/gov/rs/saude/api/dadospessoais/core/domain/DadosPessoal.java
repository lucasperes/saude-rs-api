package br.gov.rs.saude.api.dadospessoais.core.domain;

import java.time.LocalDate;

import br.gov.rs.saude.api.saude.api.core.domain.enums.global.SexoEnum;
import lombok.Data;

@Data
public class DadosPessoal {

	private Long id;
	private String nomeCompleto;
	private String nomeSocial;
	private LocalDate dataNascimento;
	private SexoEnum sexo;
	private String cpf;
	private String rg;
	private String cns;
	private String nomeMaeCompleto;
	private String nomePaiCompleto;
	private Endereco endereco;
	private String telefone;
	
}
