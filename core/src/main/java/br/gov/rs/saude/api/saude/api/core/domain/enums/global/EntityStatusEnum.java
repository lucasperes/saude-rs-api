package br.gov.rs.saude.api.saude.api.core.domain.enums.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum utilizado para guardar os possiveis Status de uma Entity
 */
@Getter
@AllArgsConstructor
public enum EntityStatusEnum {

	INATIVO(0, "Inativo"),
	ATIVO(1, "Ativo");
	
	private int code;
	private String description;
	
}
