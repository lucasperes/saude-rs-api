package br.gov.rs.saude.api.saude.api.core.utils;

import lombok.experimental.UtilityClass;

/**
 * Classe Utilitaria para Regex em Strings
 */
@UtilityClass
public class RegexUtils {

	/**
	 * Remove qualquer caracter da String que nao seja numeros de 0 a 9
	 *
	 * @param value {@link String}
	 * @return {@link String}
	 */
	public static String replaceForNumbersOnly(String value) {
		return replaceValue(value, ConstantsUtils.Regex.NOT_NUMBERS, ConstantsUtils.Values.EMPTY);
	}
	
	/**
	 * Replica valores e retorna uma {@link String}
	 * 
	 * @param value {@link String}
	 * @param regex {@link String}
	 * @param replace {@link String}
	 * @return {@link String}
	 */
	public static String replaceValue(String value, String regex, String replace) {
		if(ValidationUtils.isNotEmpty(value) && ValidationUtils.isNotEmpty(regex)) {
			return value.replaceAll(regex, replace);
		}
		return null;
	}
	
}
