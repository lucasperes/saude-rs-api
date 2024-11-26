package br.gov.rs.saude.api.dadospessoais.dataprovider.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.gov.rs.saude.api.dadospessoais.core.dataprovider.UsuariosDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoaisFilters;
import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.UsuariosRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.UsuarioEntity;
import br.gov.rs.saude.api.saude.api.core.dataprovider.impl.AbstractCustomDataProviderImpl;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.PerfisPadraoEnum;
import br.gov.rs.saude.api.saude.api.core.exception.impl.EntityNotFoundException;
import br.gov.rs.saude.api.saude.api.core.utils.messages.GlobalMappingMessagesEnum;

/**
 * Classe de implementacao DataProvider para {@link Usuario}
 */
@Component
public class UsuariosDataProviderImpl extends AbstractCustomDataProviderImpl<Usuario> implements UsuariosDataProvider {

	private static final long serialVersionUID = -6306019186416234226L;

	@Autowired
	private UsuariosRepository repository;

	@Override
	public Usuario findById(Long id) {
		UsuarioEntity result = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(GlobalMappingMessagesEnum.MSG_ERROR_ENTITY_NOT_FOUND, id));
		return mapper(result, Usuario.class);
	}
	
	@Override
	public Usuario save(Usuario entity) {
		UsuarioEntity entityMapper = mapperSafeNull(entity, UsuarioEntity.class);
		UsuarioEntity result = repository.save(entityMapper);
		return mapper(result, Usuario.class);
	}
	
	@Override
	public Page<Usuario> list(DadosPessoaisFilters filters) {
		Page<UsuarioEntity> result = repository.list(
				filters.getStatus(),
				filters.getPageable());
		return mapperSafeNull(result, Usuario.class);
	}
	
	@Override
	public Usuario disable(Long id) {
		final var entity = findById(id);
		entity.setStatus(EntityStatusEnum.INATIVO);
		// Limpa os vinculos de perfis que nao seja o Cidadao
		entity.getPerfis().removeIf(p -> !p.getId().equals(PerfisPadraoEnum.CIDADAO.getId()));
		return save(entity);
	}

}
