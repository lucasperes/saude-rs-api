package br.gov.rs.saude.api.saude.api.core.utils;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.domain.Page;

/**
 * @author Lucas P. Soares
 * @date 16 de out. de 2022
 * @contact lucasperes20@gmail.com
 * @description <b> 
 * 	Classe Utilitaria para realizar validacoes em objectos
 * </b>
 *
 */
public class ValidationUtils {

	/**
	 * Construtor privado
	 */
	private ValidationUtils() {
	}
	
	public static boolean isNull(Object value) {
		return value == null;
	}
	
	public static boolean isNotNull(Object value) {
		return !isNull(value);
	}
	
	public static boolean isEmpty(Object value) {
		return isNull(value) || value.toString().isBlank()
				|| (value instanceof Page<?> && ((Page<?>) value).isEmpty())
				|| (value instanceof Collection<?> && ((Collection<?>) value).isEmpty())
				|| (value instanceof Map<?, ?> && ((Map<?, ?>) value).isEmpty());
	}
	
	public static boolean isNotEmpty(Object value) {
		return !isEmpty(value);
	}
	
}
