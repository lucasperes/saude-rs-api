package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.request;

import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilRequest extends AbstractDTOBase {

	private static final long serialVersionUID = -8960280087933704891L;

	@NotNull
	private Integer id;
	
}
