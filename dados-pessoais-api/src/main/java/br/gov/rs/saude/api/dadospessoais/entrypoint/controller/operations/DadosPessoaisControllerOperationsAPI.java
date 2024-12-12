package br.gov.rs.saude.api.dadospessoais.entrypoint.controller.operations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.request.SalvaDadosPessoaisRequest;
import br.gov.rs.saude.api.dadospessoais.entrypoint.controller.response.DesativaDadosPessoaisResponse;
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
	@Operation(operationId = "criar", tags = "Dados Pessoais", summary = "Criar Dados Pessoais", description = "Insere os dados pessoais de um Usuário")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class)))
	})
	ResponseEntity<HttpResponseBaseDTO<SalvaDadosPessoaisResponse>> salvar(@RequestBody @Valid SalvaDadosPessoaisRequest request);

	@PutMapping("/{id}")
	@Operation(operationId = "alterar", tags = "Dados Pessoais", summary = "Alterar Dados Pessoais", description = "Altera os dados pessoais de um Usuário")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class))),
			@ApiResponse(responseCode = "404", description = "Not found", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class)))
	})
	ResponseEntity<HttpResponseBaseDTO<SalvaDadosPessoaisResponse>> alterar(
			@PathVariable Long id,
			@RequestBody @Valid SalvaDadosPessoaisRequest request);

	@DeleteMapping("/{id}")
	@Operation(operationId = "desativar", tags = "Dados Pessoais", summary = "Desativar conta do usuário", description = "Desativa logicamente o usuário (conta) e exclui os perfis a ele relacionados")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class))),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class)))
	})
	ResponseEntity<HttpResponseBaseDTO<DesativaDadosPessoaisResponse>> desativar(@PathVariable Long id);

	@GetMapping("/validar-cns/{cns}")
	@Operation(operationId = "validarCNS", tags = "Dados Pessoais", summary = "Validar CNS", description = "Valida o número do CNS informado")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = HttpResponseBaseDTO.class)))
	})
	ResponseEntity<HttpResponseBaseDTO<Void>> validarCNS(@PathVariable String cns);
	
}
