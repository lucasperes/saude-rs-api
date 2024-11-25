package br.gov.rs.saude.api.dadospessoais.dataprovider.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.rs.saude.api.dadospessoais.core.dataprovider.EnderecosDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.domain.Endereco;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.EnderecosRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.EnderecoEntity;
import br.gov.rs.saude.api.saude.api.core.dataprovider.impl.AbstractCustomDataProviderImpl;

/**
 * Classe de implementacao DataProvider para {@link Endereco}
 */
@Component
public class EnderecosDataProviderImpl extends AbstractCustomDataProviderImpl<Endereco>
		implements EnderecosDataProvider {

	private static final long serialVersionUID = -6306019186416234226L;

	@Autowired
	private EnderecosRepository repository;

	@Override
	public Endereco save(Endereco entity) {
		EnderecoEntity entityMapper = mapperSafeNull(entity, EnderecoEntity.class);
		EnderecoEntity result = repository.save(entityMapper);
		return mapper(result, Endereco.class);
	}

}
