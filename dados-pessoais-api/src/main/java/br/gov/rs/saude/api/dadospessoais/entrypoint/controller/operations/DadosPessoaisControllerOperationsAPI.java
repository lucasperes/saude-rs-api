package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.operations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.request.SalvaDadosPessoaisRequest;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.response.ListaDadosPessoaisResponse;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.response.SalvaDadosPessoaisResponse;
import br.gov.rs.saude.api.saude.api.core.domain.dto.http.HttpResponseBaseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

/**
 * Interface usada para definir os contratos das operacoes da API de dados pessoais
 */
@RequestMapping("/v1/dados-pessoais")
public interface DadosPessoaisControllerOperationsAPI {

	@GetMapping
	@Operation(operationId = "listar", tags = "Dados Pessoais", summary = "Listar Dados Pessoais", description = "Lista os dados pessoais de Usuários")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class)))
	})
	ResponseEntity<HttpResponseBaseDTO<Page<ListaDadosPessoaisResponse>>> listar(Pageable pageable);
	
	@PostMapping
	@Operation(operationId = "salvar", tags = "Dados Pessoais", summary = "Salvar Dados Pessoais", description = "Insere ou atualiza os dados pessoais de um Usuário")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class)))
	})
	ResponseEntity<HttpResponseBaseDTO<SalvaDadosPessoaisResponse>> salvar(@RequestBody @Valid SalvaDadosPessoaisRequest request);
	
}
