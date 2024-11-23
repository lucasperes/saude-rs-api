package br.gov.rs.saude.api.saude.api.core.domain.enums.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum utilizado para guardar os valores dos perfis padrao do sistema
 */
@Getter
@AllArgsConstructor
public enum PerfisPadraoEnum {

	CIDADAO(1, "Cidadão");
	
	private Integer id;
	private String nome;
	
}
