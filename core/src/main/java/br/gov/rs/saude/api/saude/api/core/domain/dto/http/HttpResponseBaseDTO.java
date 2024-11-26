package br.gov.rs.saude.api.saude.api.core.domain.dto.http;

import org.springframework.http.HttpStatus;

import br.gov.rs.saude.api.saude.api.core.domain.dto.AbstractDTOBase;
import br.gov.rs.saude.api.saude.api.core.exception.AbstractSaudeAPIBaseException;
import br.gov.rs.saude.api.saude.api.core.exception.impl.EntityNotFoundException;
import br.gov.rs.saude.api.saude.api.core.exception.impl.ValidationException;
import br.gov.rs.saude.api.saude.api.core.utils.ApplicationHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Base DTO para padronizar os responses dos Endpoints e termos mais
 * controle nos dados retornados e nos codigos de retornos
 * 
 * @param <T> tipo de dados do body
 */
@Getter
@Setter
@AllArgsConstructor
public class HttpResponseBaseDTO<T> extends AbstractDTOBase {

	private static final long serialVersionUID = 5522185635749709497L;

	private int statusCode;
	private String description;
	private String detail;
	private String trace;
	private T data;

	private HttpResponseBaseDTO(int statusCode, String description) {
		this.statusCode = statusCode;
		this.description = description;
	}

	private HttpResponseBaseDTO(int statusCode, String description, T data) {
		this.statusCode = statusCode;
		this.description = description;
		this.data = data;
	}
	
	private HttpResponseBaseDTO(int statusCode, String description, String detail) {
		this.statusCode = statusCode;
		this.description = description;
		this.detail = detail;
	}

	private HttpResponseBaseDTO(int statusCode, String description, String detail, String trace) {
		this.statusCode = statusCode;
		this.description = description;
		this.detail = detail;
		this.trace = trace;
	}

	public static <T> HttpResponseBaseDTO<T> hasOk(T data) {
		return new HttpResponseBaseDTO<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
	}

	public static <T> HttpResponseBaseDTO<T> hasNoContent() {
		return new HttpResponseBaseDTO<>(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase());
	}
	
	public static <T> HttpResponseBaseDTO<T> hasBadRequestError(ValidationException err) {
		return new HttpResponseBaseDTO<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				err.getMessageTranslated());
	}

	public static <T> HttpResponseBaseDTO<T> hasNotFoundError(EntityNotFoundException err) {
		return new HttpResponseBaseDTO<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
				err.getMessageTranslated());
	}
	
	public static <T> HttpResponseBaseDTO<T> hasInternalServerError(AbstractSaudeAPIBaseException err) {
		String trace = ApplicationHelper.extractStackTrace(err);
		return new HttpResponseBaseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				err.getMessageTranslated(), trace);
	}
	
	public static <T> HttpResponseBaseDTO<T> hasInternalServerError(Exception err) {
		String trace = ApplicationHelper.extractStackTrace(err);
		return new HttpResponseBaseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				err.getMessage(), trace);
	}

}
