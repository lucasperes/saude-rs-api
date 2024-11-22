package br.gov.rs.saude.api.dadospessoais.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.CidadesRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.DadosPessoaisRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.EnderecosRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.UsuariosRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.CidadeEntity;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.DadosPessoalEntity;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.EnderecoEntity;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.UsuarioEntity;
import br.gov.rs.saude.api.dadospessoais.domain.model.Usuario;
import br.gov.rs.saude.api.saude.api.core.exception.impl.EntityNotFoundException;
import br.gov.rs.saude.api.saude.api.core.usecase.IUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.usecase.impl.AbstractUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.utils.messages.GlobalMappingMessagesEnum;

@Component
public class SalvarDadosPessoaisUseCase extends AbstractUseCaseBase
		implements IUseCaseBase<Usuario, Usuario> {

	private static final long serialVersionUID = 4858620194587134870L;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	@Autowired
	private DadosPessoaisRepository dadosPessoaisRepository;
	@Autowired
	private EnderecosRepository enderecosRepository;
	@Autowired
	private CidadesRepository cidadesRepository;
	
	@Override
	@Transactional
	public Usuario execute(Usuario entity) {
		// ModelMapper
		UsuarioEntity usuario = mapperSafeNull(entity, UsuarioEntity.class);
		
		// Salva os dados antes evitando o erro: org.hibernate.TransientPropertyValueException: Not-null property
		EnderecoEntity endereco = usuario.getDadosPessoal().getEndereco();
		final Integer cidadeId = endereco.getCidade().getId();
		CidadeEntity cidade = cidadesRepository.findById(cidadeId)
				.orElseThrow(() -> new EntityNotFoundException(GlobalMappingMessagesEnum.MSG_ERROR_ENTITY_NOT_FOUND, cidadeId));
		endereco.setCidade(cidade);
		endereco = enderecosRepository.save(endereco);
		
		DadosPessoalEntity dadosPessoal = usuario.getDadosPessoal();
		dadosPessoal.setEndereco(endereco);
		dadosPessoal = dadosPessoaisRepository.save(dadosPessoal);
		
		usuario.setDadosPessoal(dadosPessoal);
		usuario = usuariosRepository.save(usuario);
		
		return mapperSafeNull(usuario, Usuario.class);
	}

}
