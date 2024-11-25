package br.gov.rs.saude.api.saude.api.core.dataprovider.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.gov.rs.saude.api.saude.api.core.dataprovider.IDataProviderBase;
import br.gov.rs.saude.api.saude.api.core.domain.model.ModelMapperBase;
import lombok.Getter;

/**
 * Classe Abstrata que auxilia na implementacao dos metodos base de um Provider de Dados
 *
 * @param <T> tipo da entidade
 */
@Component
public abstract class AbstractCustomDataProviderImpl<T> extends ModelMapperBase implements IDataProviderBase<T> {

	private static final long serialVersionUID = -8002954081487785388L;
	
	@Getter
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
}
