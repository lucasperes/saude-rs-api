package br.gov.rs.saude.api.dadospessoais.core.usecase;

import java.util.Set;

import br.gov.rs.saude.api.dadospessoais.utils.DadosPessoaisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.rs.saude.api.dadospessoais.core.dataprovider.DadosPessoaisDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.dataprovider.EnderecosDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.dataprovider.PerfisDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.dataprovider.UsuariosDataProvider;
import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoais;
import br.gov.rs.saude.api.dadospessoais.core.domain.Endereco;
import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.PerfisPadraoEnum;
import br.gov.rs.saude.api.saude.api.core.usecase.IUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.usecase.impl.AbstractUseCaseBase;

/**
 * Classe UseCase para Salvar Dados Pessoais de um {@link Usuario}
 */
@Component
public class CriarDadosPessoaisUseCase extends AbstractUseCaseBase
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

    @Override
    @Transactional
    public Usuario execute(Usuario usuario) {
        DadosPessoaisUtils.validarDadosPessoais(usuario);

        // Salva os dados antes evitando o erro: org.hibernate.TransientPropertyValueException: Not-null property
        Endereco endereco = usuario.getDadosPessoais().getEndereco();;
        endereco = enderecosDataProvider.save(endereco);

        DadosPessoais dadosPessoais = usuario.getDadosPessoais();
        dadosPessoais.setEndereco(endereco);
        dadosPessoais = dadosPessoaisDataProvider.save(dadosPessoais);

        usuario.setDadosPessoais(dadosPessoais);
        usuario.setStatus(EntityStatusEnum.ATIVO);

        final Integer perfilCidadaoId = PerfisPadraoEnum.CIDADAO.getId();
        final var perfilCidadao = perfisDataProvider.findById(perfilCidadaoId);
        usuario.setPerfis(Set.of(perfilCidadao));

        return usuariosDataProvider.save(usuario);
    }

}
