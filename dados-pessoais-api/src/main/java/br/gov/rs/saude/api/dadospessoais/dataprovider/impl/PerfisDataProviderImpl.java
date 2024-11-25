package br.gov.rs.saude.api.dadospessoais.dataprovider.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.rs.saude.api.dadospessoais.core.dataprovider.PerfisDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.domain.Perfil;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.PerfisRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.PerfilEntity;
import br.gov.rs.saude.api.saude.api.core.dataprovider.impl.AbstractCustomDataProviderImpl;
import br.gov.rs.saude.api.saude.api.core.exception.impl.EntityNotFoundException;
import br.gov.rs.saude.api.saude.api.core.utils.messages.GlobalMappingMessagesEnum;

/**
 * Classe de implementacao DataProvider para {@link Perfil}
 */
@Component
public class PerfisDataProviderImpl extends AbstractCustomDataProviderImpl<Perfil> implements PerfisDataProvider {

	private static final long serialVersionUID = -6306019186416234226L;

	@Autowired
	private PerfisRepository repository;

	@Override
	public Perfil findById(Integer id) {
		PerfilEntity result = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(GlobalMappingMessagesEnum.MSG_ERROR_ENTITY_NOT_FOUND, id));
		return mapper(result, Perfil.class);
	}

}
