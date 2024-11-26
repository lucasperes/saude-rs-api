package br.gov.rs.saude.api.dadospessoais.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.rs.saude.api.dadospessoais.core.dataprovider.UsuariosDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.saude.api.core.usecase.IUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.usecase.impl.AbstractUseCaseBase;

/**
 * Classe UseCase para Desativar o cadastro de um {@link Usuario}
 */
@Component
public class DesativarContaUseCase extends AbstractUseCaseBase implements IUseCaseBase<Long, Usuario> {

	private static final long serialVersionUID = -977893995407109187L;

	@Autowired
	private UsuariosDataProvider usuariosDataProvider;
	
	@Override
	@Transactional
	public Usuario execute(Long id) {
		return usuariosDataProvider.disable(id);
	}

}
