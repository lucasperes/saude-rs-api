package br.gov.rs.saude.api.dadospessoais.dataprovider.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.rs.saude.api.dadospessoais.core.dataprovider.DadosPessoaisDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoal;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.DadosPessoaisRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.DadosPessoalEntity;
import br.gov.rs.saude.api.saude.api.core.dataprovider.impl.AbstractCustomDataProviderImpl;

/**
 * Classe de implementacao DataProvider para {@link DadosPessoal}
 */
@Component
public class DadosPessoaisDataProviderImpl extends AbstractCustomDataProviderImpl<DadosPessoal>
		implements DadosPessoaisDataProvider {

	private static final long serialVersionUID = -6306019186416234226L;

	@Autowired
	private DadosPessoaisRepository repository;

	@Override
	public DadosPessoal save(DadosPessoal entity) {
		DadosPessoalEntity entityMapper = mapperSafeNull(entity, DadosPessoalEntity.class);
		DadosPessoalEntity result = repository.save(entityMapper);
		return mapper(result, DadosPessoal.class);
	}

}
