package br.gov.rs.saude.api.dadospessoais.dataprovider.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.rs.saude.api.dadospessoais.core.dataprovider.CidadesDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.domain.Cidade;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.CidadesRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.CidadeEntity;
import br.gov.rs.saude.api.saude.api.core.dataprovider.impl.AbstractCustomDataProviderImpl;
import br.gov.rs.saude.api.saude.api.core.exception.impl.EntityNotFoundException;
import br.gov.rs.saude.api.saude.api.core.utils.messages.GlobalMappingMessagesEnum;

/**
 * Classe de implementacao DataProvider para {@link Cidade}
 */
@Component
public class CidadesDataProviderImpl extends AbstractCustomDataProviderImpl<Cidade> implements CidadesDataProvider {

	private static final long serialVersionUID = -6306019186416234226L;

	@Autowired
	private CidadesRepository repository;

	@Override
	public Cidade findById(Integer id) {
		CidadeEntity entity = repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException(GlobalMappingMessagesEnum.MSG_ERROR_ENTITY_NOT_FOUND, id));
		return mapper(entity, Cidade.class);
	}

}
