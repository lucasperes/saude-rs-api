package br.gov.rs.saude.api.dadospessoais.core.usecase;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.CidadesRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.DadosPessoaisRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.EnderecosRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.PerfisRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.UsuariosRepository;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.CidadeEntity;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.DadosPessoalEntity;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.EnderecoEntity;
import br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity.UsuarioEntity;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.PerfisPadraoEnum;
import br.gov.rs.saude.api.saude.api.core.exception.impl.EntityNotFoundException;
import br.gov.rs.saude.api.saude.api.core.usecase.IUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.usecase.impl.AbstractUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.utils.ValidationUtils;
import br.gov.rs.saude.api.saude.api.core.utils.messages.GlobalMappingMessagesEnum;

@Component
public class SalvarDadosPessoaisUseCase extends AbstractUseCaseBase
		implements IUseCaseBase<Usuario, Usuario> {

	private static final long serialVersionUID = 4858620194587134870L;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	@Autowired
	private PerfisRepository perfisRepository;
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
		// Se o ID for nulo, e um novo registro
		if(ValidationUtils.isNull(usuario.getId())) {
			usuario.setStatus(EntityStatusEnum.ATIVO);
			final Integer perfilCidadaoId = PerfisPadraoEnum.CIDADAO.getId();
			final var perfilCidadao = perfisRepository.findById(perfilCidadaoId)
					.orElseThrow(() -> new EntityNotFoundException(GlobalMappingMessagesEnum.MSG_ERROR_ENTITY_NOT_FOUND, perfilCidadaoId));
			usuario.setPerfis(Set.of(perfilCidadao));
		} else {
			final Long usuarioId = usuario.getId();
			UsuarioEntity usuarioDB = usuariosRepository.findById(usuarioId)
					.orElseThrow(() -> new EntityNotFoundException(GlobalMappingMessagesEnum.MSG_ERROR_ENTITY_NOT_FOUND, usuarioId));
			usuario.setStatus(usuarioDB.getStatus());
			usuario.setPerfis(usuarioDB.getPerfis());
		}
		
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
