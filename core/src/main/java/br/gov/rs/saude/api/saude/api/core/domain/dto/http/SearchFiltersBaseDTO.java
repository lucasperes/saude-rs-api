package br.gov.rs.saude.api.saude.api.core.domain.dto.http;

import org.springframework.data.domain.Pageable;

import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe DTO Base para filtrar as entidades em pesquisas
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchFiltersBaseDTO extends AbstractDTOBase {

	private static final long serialVersionUID = -1494821115768652941L;

	private Pageable pageable;
	
}
