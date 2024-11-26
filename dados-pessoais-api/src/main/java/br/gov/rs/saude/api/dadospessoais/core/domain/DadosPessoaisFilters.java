package br.gov.rs.saude.api.dadospessoais.core.domain;

import org.springframework.data.domain.Pageable;

import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosPessoaisFilters {
	
	private Pageable pageable;
	private EntityStatusEnum status;

}
