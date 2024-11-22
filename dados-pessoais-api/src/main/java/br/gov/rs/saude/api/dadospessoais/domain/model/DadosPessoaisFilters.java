package br.gov.rs.saude.api.dadospessoais.domain.model;

import org.springframework.data.domain.Pageable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosPessoaisFilters {
	
	private Pageable pageable;

}
