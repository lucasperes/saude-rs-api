package br.gov.rs.saude.api.saude.api.core.exception.impl;

import br.gov.rs.saude.api.saude.api.core.exception.AbstractSaudeAPIBaseException;
import br.gov.rs.saude.api.saude.api.core.utils.messages.IMessages;

/**
 * Classe Exception para validacoes em gerais
 */
public class ValidationException extends AbstractSaudeAPIBaseException {

	private static final long serialVersionUID = -6156341141471340696L;

	public ValidationException(IMessages messages, Object ... params) {
		super(messages, params);
	}
	
	public ValidationException(Throwable cause, IMessages messages, Object ... params) {
		super(messages, cause, params);
	}
	
}
