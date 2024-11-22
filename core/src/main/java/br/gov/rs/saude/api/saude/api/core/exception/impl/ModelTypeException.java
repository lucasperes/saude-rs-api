package br.gov.rs.saude.api.saude.api.core.exception.impl;

import br.gov.rs.saude.api.saude.api.core.exception.AbstractSaudeAPIBaseException;
import br.gov.rs.saude.api.saude.api.core.utils.messages.IMessages;

/**
 * Classe Exception para conversoes ModelMapper
 */
public class ModelTypeException extends AbstractSaudeAPIBaseException {

	private static final long serialVersionUID = -6156341141471340696L;

	public ModelTypeException(IMessages messages, Object ... params) {
		super(messages, params);
	}
	
	public ModelTypeException(Throwable cause, IMessages messages, Object ... params) {
		super(messages, cause, params);
	}
	
}
