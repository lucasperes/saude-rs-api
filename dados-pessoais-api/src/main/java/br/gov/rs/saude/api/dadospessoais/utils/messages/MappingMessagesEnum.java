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
	MSG_ERROR_VALIDATION_NULL_FIELD("msg.error.validation.null_field"),
	MSG_ERROR_VALIDATION_DOCUMENT_INVALID("msg.error.validation.document_invalid"),
	MSG_ERROR_VALIDATION_ENTITY_NOT_PERMIT_OPERATION_BY_STATUS("msg.error.validation.entity.not_permit_operation_by_status");

	private String key;
	
}
