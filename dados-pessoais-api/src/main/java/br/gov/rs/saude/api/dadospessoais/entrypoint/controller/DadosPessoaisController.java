package br.gov.rs.saude.api.dadospessoais.entrypoint.controller;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.gov.rs.saude.api.dadospessoais.domain.model.DadosPessoaisFilters;
import br.gov.rs.saude.api.dadospessoais.domain.model.Usuario;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.dto.request.SalvaDadosPessoaisRequestDTO;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.dto.response.ListaDadosPessoaisResponseDTO;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.dto.response.SalvaDadosPessoaisResponseDTO;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.operations.DadosPessoaisControllerOperationsAPI;
import br.gov.rs.saude.api.dadospessoais.usecase.ListarDadosPessoaisUseCase;
import br.gov.rs.saude.api.dadospessoais.usecase.SalvarDadosPessoaisUseCase;
import br.gov.rs.saude.api.saude.api.core.domain.dto.http.HttpResponseBaseDTO;
import br.gov.rs.saude.api.saude.api.core.entrypoint.controller.AbstractControllerBase;
import jakarta.validation.Valid;

/**
 * Classe Controller API para expor Endpoints para Dados Pessoais
 */
@RestController
public class DadosPessoaisController extends AbstractControllerBase implements DadosPessoaisControllerOperationsAPI {

	private static final long serialVersionUID = -198769903066758139L;
	
	@Autowired
	private ListarDadosPessoaisUseCase listarUseCase;
	@Autowired
	private SalvarDadosPessoaisUseCase salvarUseCase;
	
	public DadosPessoaisController() {
		configMappers();
	}

	@Override
	public ResponseEntity<HttpResponseBaseDTO<Page<ListaDadosPessoaisResponseDTO>>> listar(Pageable pageable) {
		return process(() -> {
			final var filters = new DadosPessoaisFilters();
			filters.setPageable(pageable);
			final var response = listarUseCase.execute(filters);
			
			return mapperSafeNull(response, ListaDadosPessoaisResponseDTO.class);
		});
	}

	@Override
	public ResponseEntity<HttpResponseBaseDTO<SalvaDadosPessoaisResponseDTO>> salvar(
			@Valid SalvaDadosPessoaisRequestDTO request) {
		return process(() -> {
			final var entity = mapperSafeNull(request, Usuario.class);
			final var response = salvarUseCase.execute(entity);
			
			return mapperSafeNull(response, SalvaDadosPessoaisResponseDTO.class);
		});
	}
	
	private void configMappers() {
		getMODEL_MAPPER().addMappings(new PropertyMap<Usuario, ListaDadosPessoaisResponseDTO>() {
			@Override
			protected void configure() {
				map(source.getId(), destination.getUsuarioId());
			}
		});
		getMODEL_MAPPER().addMappings(new PropertyMap<SalvaDadosPessoaisRequestDTO, Usuario>() {
			@Override
			protected void configure() {
				map(source.getUsuarioId(), destination.getId());
			}
		});
		getMODEL_MAPPER().addMappings(new PropertyMap<Usuario, SalvaDadosPessoaisResponseDTO>() {
			@Override
			protected void configure() {
				map(source.getId(), destination.getUsuarioId());
			}
		});
	}

}
