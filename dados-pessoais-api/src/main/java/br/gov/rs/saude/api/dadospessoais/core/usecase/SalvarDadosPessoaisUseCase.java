package br.gov.rs.saude.api.dadospessoais.core.usecase;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.rs.saude.api.dadospessoais.core.dataprovider.CidadesDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.dataprovider.DadosPessoaisDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.dataprovider.EnderecosDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.dataprovider.PerfisDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.dataprovider.UsuariosDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.domain.Cidade;
import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoal;
import br.gov.rs.saude.api.dadospessoais.core.domain.Endereco;
import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.dadospessoais.utils.messages.MappingMessagesEnum;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.PerfisPadraoEnum;
import br.gov.rs.saude.api.saude.api.core.exception.impl.ValidationException;
import br.gov.rs.saude.api.saude.api.core.usecase.IUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.usecase.impl.AbstractUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.utils.ValidationUtils;

/**
 * Classe UseCase para Salvar Dados Pessoais de um {@link Usuario}
 */
@Component
public class SalvarDadosPessoaisUseCase extends AbstractUseCaseBase
		implements IUseCaseBase<Usuario, Usuario> {

	private static final long serialVersionUID = 4858620194587134870L;
	
	@Autowired
	private UsuariosDataProvider usuariosDataProvider;
	@Autowired
	private PerfisDataProvider perfisDataProvider;
	@Autowired
	private DadosPessoaisDataProvider dadosPessoaisDataProvider;
	@Autowired
	private EnderecosDataProvider enderecosDataProvider;
	@Autowired
	private CidadesDataProvider cidadesDataProvider;
	
	@Override
	@Transactional
	public Usuario execute(Usuario entity) {
		// Realiza as validacoes de negocio antes de prosseguir
		// Valida CPF nao valido
		final String cpf = entity.getDadosPessoal().getCpf();
		if(!ValidationUtils.isCPFValid(cpf)) {
			throw new ValidationException(MappingMessagesEnum.MSG_ERROR_VALIDATION_DOCUMENT_INVALID, cpf, "CPF");
		}
		
		// Se o ID for nulo, e um novo registro
		if(ValidationUtils.isNull(entity.getId())) {
			entity.setStatus(EntityStatusEnum.ATIVO);
			final Integer perfilCidadaoId = PerfisPadraoEnum.CIDADAO.getId();
			final var perfilCidadao = perfisDataProvider.findById(perfilCidadaoId);
			entity.setPerfis(Set.of(perfilCidadao));
		} else {
			final Long usuarioId = entity.getId();
			final var usuarioDB = usuariosDataProvider.findById(usuarioId);
			entity.setStatus(usuarioDB.getStatus());
			entity.setPerfis(usuarioDB.getPerfis());
		}
		
		// Salva os dados antes evitando o erro: org.hibernate.TransientPropertyValueException: Not-null property
		Endereco endereco = entity.getDadosPessoal().getEndereco();
		final Integer cidadeId = endereco.getCidade().getId();
		Cidade cidade = cidadesDataProvider.findById(cidadeId);
		endereco.setCidade(cidade);
		endereco = enderecosDataProvider.save(endereco);
		
		DadosPessoal dadosPessoal = entity.getDadosPessoal();
		dadosPessoal.setEndereco(endereco);
		dadosPessoal = dadosPessoaisDataProvider.save(dadosPessoal);
		
		entity.setDadosPessoal(dadosPessoal);
		entity = usuariosDataProvider.save(entity);
		
		return entity;
	}

}
