package br.gov.rs.saude.api.saude.api.core.dataprovider;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Interface Base para ser implementada nos dataprovider dos modulos
 * 
 * @param <T>
 */
public interface IDataProviderBase<T> {
	
	/**
	 * Deve retornar uma instancia valida de {@link JdbcTemplate} para acesso a dados
	 *
	 * @return {@link JdbcTemplate}
	 */
	JdbcTemplate getJdbcTemplate();
	
}
