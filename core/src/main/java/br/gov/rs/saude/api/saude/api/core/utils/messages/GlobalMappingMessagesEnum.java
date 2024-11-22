package br.gov.rs.saude.api.saude.api.core.utils.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum Utilizado para mapear as Keys das mensagens da aplicacao
 */
@Getter
@AllArgsConstructor
public enum GlobalMappingMessagesEnum implements IMessages {

	// ERROS
	MSG_ERROR_CONVERTER_USER_TYPE_JPA("msg.error.converter.user_type_jpa"),
	MSG_ERROR_VALIDATION_LIST_SOURCE_IS_NULL("msg.error.validation.list_source_is_null"),
	MSG_ERROR_CONVERTER_SOURCE_TO_STRING("msg.error.converter.source_to_string"),
	MSG_ERROR_CONVERTER_SOURCE_TO_TARGET("msg.error.converter.source_to_target"),
	MSG_ERROR_ENTITY_NOT_FOUND("msg.error.entity.not_found");
	
	private String key;
	
}
