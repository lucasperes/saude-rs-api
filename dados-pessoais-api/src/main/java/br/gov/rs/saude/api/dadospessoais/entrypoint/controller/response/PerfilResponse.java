package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.response;

import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilResponse extends AbstractDTOBase {

	private static final long serialVersionUID = -8960280087933704891L;

	private Integer id;
	private String nome;
	
}
