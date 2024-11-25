package br.gov.rs.saude.api.dadospessoais.utils.messages;

import br.gov.rs.saude.api.saude.api.core.utils.messages.IMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum Utilizado para mapear as Keys das mensagens da aplicacao
 */
@Getter
@AllArgsConstructor
public enum MappingMessagesEnum implements IMessages {

	// ERROS
	MSG_ERROR_VALIDATION_DOCUMENT_INVALID("msg.error.validation.document_invalid");
	
	private String key;
	
}
