package br.gov.rs.saude.api.saude.api.core.exception.impl;

import br.gov.rs.saude.api.saude.api.core.exception.AbstractSaudeAPIBaseException;
import br.gov.rs.saude.api.saude.api.core.utils.messages.IMessages;

/**
 * Classe Exception para buscas de entidades sem resultados
 */
public class EntityNotFoundException extends AbstractSaudeAPIBaseException {

	private static final long serialVersionUID = -6156341141471340696L;

	public EntityNotFoundException(IMessages messages, Object ... params) {
		super(messages, params);
	}
	
	public EntityNotFoundException(Throwable cause, IMessages messages, Object ... params) {
		super(messages, cause, params);
	}
	
}
