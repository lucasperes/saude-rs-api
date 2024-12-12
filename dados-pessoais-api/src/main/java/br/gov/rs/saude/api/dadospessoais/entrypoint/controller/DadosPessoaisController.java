package br.gov.rs.saude.api.dadospessoais.entrypoint.controller;

import br.gov.rs.saude.api.dadospessoais.core.usecase.*;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoaisFilters;
import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.operations.DadosPessoaisControllerOperationsAPI;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.request.SalvaDadosPessoaisRequest;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.response.DesativaDadosPessoaisResponse;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.response.ListaDadosPessoaisResponse;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.response.SalvaDadosPessoaisResponse;
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
	private CriarDadosPessoaisUseCase criarUseCase;
	@Autowired
	private AlterarDadosPessoaisUseCase alterarUseCase;
	@Autowired
	private DesativarContaUseCase desativaUseCase;
	@Autowired
	private ValidarCnsUseCase validarCnsUseCase;
	
	public DadosPessoaisController() {
		configMappers();
	}

	@Override
	public ResponseEntity<HttpResponseBaseDTO<Page<ListaDadosPessoaisResponse>>> listar(Pageable pageable) {
		return process(() -> {
			final var filters = new DadosPessoaisFilters();
			filters.setPageable(pageable);
			final var response = listarUseCase.execute(filters);
			
			return mapperSafeNull(response, ListaDadosPessoaisResponse.class);
		});
	}

	@Override
	public ResponseEntity<HttpResponseBaseDTO<SalvaDadosPessoaisResponse>> salvar(
			@Valid SalvaDadosPessoaisRequest request) {
		return process(() -> {
			final var entity = mapperSafeNull(request, Usuario.class);
			final var response = criarUseCase.execute(entity);
			
			return mapperSafeNull(response, SalvaDadosPessoaisResponse.class);
		});
	}

	@Override
	public ResponseEntity<HttpResponseBaseDTO<SalvaDadosPessoaisResponse>> alterar(
			Long id,
			@Valid SalvaDadosPessoaisRequest request) {
		return process(() -> {
			Usuario usuario = mapperSafeNull(request, Usuario.class);
			usuario.setId(id);
			Usuario result = alterarUseCase.execute(usuario);
			return mapperSafeNull(result, SalvaDadosPessoaisResponse.class);
		});
	}

	@Override
	public ResponseEntity<HttpResponseBaseDTO<DesativaDadosPessoaisResponse>> desativar(Long id) {
		return process(() -> {
			final var response = desativaUseCase.execute(id);
			return mapperSafeNull(response, DesativaDadosPessoaisResponse.class);
		});
	}

	@Override
	public ResponseEntity<HttpResponseBaseDTO<Void>> validarCNS(String cns) {
		return process(() -> {
			validarCnsUseCase.execute(cns);
			return null;
		});
	}
	
	private void configMappers() {
		getMODEL_MAPPER().addMappings(new PropertyMap<Usuario, ListaDadosPessoaisResponse>() {
			@Override
			protected void configure() {
				map(source.getId(), destination.getUsuarioId());
			}
		});
		getMODEL_MAPPER().addMappings(new PropertyMap<Usuario, SalvaDadosPessoaisResponse>() {
			@Override
			protected void configure() {
				map(source.getId(), destination.getUsuarioId());
			}
		});
	}

}
