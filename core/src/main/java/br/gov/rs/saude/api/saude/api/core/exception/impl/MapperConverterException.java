package br.gov.rs.saude.api.saude.api.core.exception.impl;

import br.gov.rs.saude.api.saude.api.core.exception.AbstractSaudeAPIBaseException;
import br.gov.rs.saude.api.saude.api.core.utils.messages.IMessages;

/**
 * Classe Exception para conversao de JPA Model Types
 */
public class MapperConverterException extends AbstractSaudeAPIBaseException {

	private static final long serialVersionUID = -6156341141471340696L;

	public MapperConverterException(IMessages messages, Object ... params) {
		super(messages, params);
	}
	
	public MapperConverterException(Throwable cause, IMessages messages, Object ... params) {
		super(messages, cause, params);
	}
	
}
