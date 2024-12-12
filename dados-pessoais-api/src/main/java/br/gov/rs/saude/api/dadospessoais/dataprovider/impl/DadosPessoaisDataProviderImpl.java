package br.gov.rs.saude.api.dadospessoais.dataprovider.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.rs.saude.api.dadospessoais.core.dataprovider.DadosPessoaisDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoais;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.DadosPessoaisRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.DadosPessoaisEntity;
import br.gov.rs.saude.api.saude.api.core.dataprovider.impl.AbstractCustomDataProviderImpl;

/**
 * Classe de implementacao DataProvider para {@link DadosPessoais}
 */
@Component
public class DadosPessoaisDataProviderImpl extends AbstractCustomDataProviderImpl<DadosPessoais>
		implements DadosPessoaisDataProvider {

	private static final long serialVersionUID = -6306019186416234226L;

	@Autowired
	private DadosPessoaisRepository repository;

	@Override
	public DadosPessoais save(DadosPessoais entity) {
		DadosPessoaisEntity entityMapper = mapperSafeNull(entity, DadosPessoaisEntity.class);
		DadosPessoaisEntity result = repository.save(entityMapper);
		return mapper(result, DadosPessoais.class);
	}

}
