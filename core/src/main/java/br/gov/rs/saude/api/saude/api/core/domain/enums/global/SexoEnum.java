package br.gov.rs.saude.api.saude.api.core.domain.enums.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum utilizado para guardar os valores de Sexo de um Cidadao
 */
@Getter
@AllArgsConstructor
public enum SexoEnum {
	
	MASCULINO("M", "Masculino"),
	FEMININO("F", "Feminino"),
	NAO_INFORMADO("UN", "Não Informado");
	
	private String code;
	private String description;
	
	public static SexoEnum getByCode(String code) {
		if(code != null) {
			for(SexoEnum sexo : values()) {
				if(sexo.getCode().equals(code)) {
					return sexo;
				}
			}
		}
		return null;
	}

}
