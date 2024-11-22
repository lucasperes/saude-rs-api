package br.gov.rs.saude.api.saude.api.core.entrypoint.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.gov.rs.saude.api.saude.api.core.domain.dto.http.HttpResponseBaseDTO;
import br.gov.rs.saude.api.saude.api.core.domain.model.ModelMapperBase;
import br.gov.rs.saude.api.saude.api.core.utils.ValidationUtils;
import br.gov.rs.saude.api.saude.api.core.utils.action.IProcessActionAPI;

/**
 * Classe Abstrata para ser estendidas pelas classes controller para facilitar e
 * centralizar a execucao dos metodos dos Endpoints
 */
public abstract class AbstractControllerBase extends ModelMapperBase {

	private static final long serialVersionUID = 1842881817338784635L;

	/**
	 * Executa e processa uma requisicao e realiza as tratativas de retorno
	 *
	 * @param <T> Tipo de Retorno do Process
	 * @param action Acao a ser processada
	 * @return {@link ResponseEntity} de {@link HttpResponseBaseDTO} de um tipo <T>
	 */
	protected <T> ResponseEntity<HttpResponseBaseDTO<T>> process(IProcessActionAPI<T> action) {
		try {
			T response = action.process();
			if(ValidationUtils.isEmpty(response)) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpResponseBaseDTO.hasNoContent());
			}
			return ResponseEntity.ok(HttpResponseBaseDTO.hasOk(response));
		} catch(Exception err) {
			throw err;
		}
	}
	
}
