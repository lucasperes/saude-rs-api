package br.gov.rs.saude.api.saude.api.core.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.gov.rs.saude.api.saude.api.core.config.i18n.TranslateService;
import br.gov.rs.saude.api.saude.api.core.domain.dto.http.HttpResponseBaseDTO;
import br.gov.rs.saude.api.saude.api.core.exception.AbstractSaudeAPIBaseException;
import br.gov.rs.saude.api.saude.api.core.exception.impl.EntityNotFoundException;
import br.gov.rs.saude.api.saude.api.core.exception.impl.ValidationException;
import br.gov.rs.saude.api.saude.api.core.utils.messages.GlobalMappingMessagesEnum;

/**
 * Classe Global que controla os retornos das exceptions do sistema
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalHandlerException.class);
	
	@Autowired
	private TranslateService translate;
	
	@ExceptionHandler({ValidationException.class})
	public ResponseEntity<HttpResponseBaseDTO<?>> handlerBadRequestException(ValidationException err, WebRequest request) {
		// Logs
		loggerDefaultError400(err);
		
		String msgError = translate.getMessage(err.getMessages().getKey(), err.getParams());
		err.setMessageTranslated(msgError);
		
		final var responseDto = HttpResponseBaseDTO.hasBadRequestError(err);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
	}
	
	@ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<HttpResponseBaseDTO<?>> handlerNotFoundException(EntityNotFoundException err, WebRequest request) {
		// Logs
		loggerDefaultError404(err);
		
		String msgError = translate.getMessage(err.getMessages().getKey(), err.getParams());
		err.setMessageTranslated(msgError);
		
		final var responseDto = HttpResponseBaseDTO.hasNotFoundError(err);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
	}
	
	@ExceptionHandler({AbstractSaudeAPIBaseException.class})
	public ResponseEntity<HttpResponseBaseDTO<?>> handlerIternalServerException(AbstractSaudeAPIBaseException err, WebRequest request) {
		// Logs
		loggerDefaultError500(err);
		
		String msgError = translate.getMessage(err.getMessages().getKey(), err.getParams());
		err.setMessageTranslated(msgError);
		
		final var responseDto = HttpResponseBaseDTO.hasInternalServerError(err);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
	}
	
	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<HttpResponseBaseDTO<?>> handlerIternalServerException(RuntimeException err, WebRequest request) {
		// Logs
		loggerDefaultError500(err);
		
		final var responseDto = HttpResponseBaseDTO.hasInternalServerError(err);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
	}
	
	private void loggerDefaultError400(ValidationException err) {
		final var msgErrorDef = translate.getMessage(GlobalMappingMessagesEnum.MSG_ERROR_HTTP_400.getKey(), "",
				err.getMessageTranslated());
		LOGGER.error(msgErrorDef, err);
	}

	private void loggerDefaultError404(EntityNotFoundException err) {
		final var msgErrorDef = translate.getMessage(GlobalMappingMessagesEnum.MSG_ERROR_HTTP_404.getKey(), "",
				err.getMessageTranslated());
		LOGGER.error(msgErrorDef, err);
	}
	
	private void loggerDefaultError500(AbstractSaudeAPIBaseException err) {
		final var msgErrorDef = translate.getMessage(GlobalMappingMessagesEnum.MSG_ERROR_HTTP_500.getKey(), "",
				err.getMessageTranslated());
		LOGGER.error(msgErrorDef, err);
	}
	
	private void loggerDefaultError500(RuntimeException err) {
		final var msgErrorDef = translate.getMessage(GlobalMappingMessagesEnum.MSG_ERROR_HTTP_500.getKey(), "",
				err.getMessage());
		LOGGER.error(msgErrorDef, err);
	}
	
}
