package br.gov.rs.saude.api.saude.api.core.exception;

import br.gov.rs.saude.api.saude.api.core.utils.messages.IMessages;
import lombok.Getter;

/**
 * Classe Base para ser herdada por todas as classes Exceptions do sistema
 */
@Getter
public abstract class AbstractSaudeAPIBaseException extends RuntimeException {

	private static final long serialVersionUID = -8308357209717823235L;

	private IMessages messages;
	private Object[] params;
	
	public AbstractSaudeAPIBaseException(IMessages messages, Object ... params) {
		super(messages.getKey());
		this.messages = messages;
		this.params = params;
	}
	
	public AbstractSaudeAPIBaseException(Throwable cause, IMessages messages, Object ... params) {
		super(messages.getKey(), cause);
		this.messages = messages;
		this.params = params;
	}
	
}
