package br.gov.rs.saude.api.dadospessoais.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoaisFilters;
import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.UsuariosRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.UsuarioEntity;
import br.gov.rs.saude.api.saude.api.core.usecase.IUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.usecase.impl.AbstractUseCaseBase;

@Component
public class ListarDadosPessoaisUseCase extends AbstractUseCaseBase
		implements IUseCaseBase<DadosPessoaisFilters, Page<Usuario>> {

	private static final long serialVersionUID = 4858620194587134870L;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> execute(DadosPessoaisFilters filters) {
		Page<UsuarioEntity> result = usuariosRepository.findAll(filters.getPageable());
		return mapperSafeNull(result, Usuario.class);
	}

}
