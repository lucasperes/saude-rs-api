package br.gov.rs.saude.api.saude.api.core.config.i18n;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

/**
 * Classe Service para fazer um facade das exibicao de mensagens
 */
@Service
public class TranslateService {

	@Autowired
	@Qualifier("bundleMessageSource")
	private ReloadableResourceBundleMessageSource messageSource;
	
	/**
	 * Retorna uma mensagem com parametros
	 *
	 * @param key {@link String}
	 * @param params Array de {@link Object}
	 * @return {@link String}
	 */
	public String getMessage(String key, Object ... params) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(key, params, locale);
	}
	
	/**
	 * Retorna uma mensagem com parametros, caso nao ache retorna uma default
	 *
	 * @param key {@link String}
	 * @param params Array de {@link Object}
	 * @return {@link String}
	 */
	public String getMessage(String key, String msgDefault, Object ... params) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(key, params, msgDefault, locale);
	}
	
}
