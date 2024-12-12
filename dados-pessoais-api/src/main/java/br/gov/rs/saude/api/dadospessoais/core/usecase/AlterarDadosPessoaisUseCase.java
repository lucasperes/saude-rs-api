package br.gov.rs.saude.api.dadospessoais.core.usecase;

import br.gov.rs.saude.api.dadospessoais.core.dataprovider.*;
import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoais;
import br.gov.rs.saude.api.dadospessoais.core.domain.Endereco;
import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.dadospessoais.utils.DadosPessoaisUtils;
import br.gov.rs.saude.api.dadospessoais.utils.messages.MappingMessagesEnum;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;
import br.gov.rs.saude.api.saude.api.core.exception.impl.ValidationException;
import br.gov.rs.saude.api.saude.api.core.usecase.IUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.usecase.impl.AbstractUseCaseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe UseCase para Alterar Dados Pessoais de um {@link Usuario}
 */
@Component
public class AlterarDadosPessoaisUseCase extends AbstractUseCaseBase
        implements IUseCaseBase<Usuario, Usuario> {

    private static final long serialVersionUID = 4858620194587134870L;

    @Autowired
    private UsuariosDataProvider usuariosDataProvider;
    @Autowired
    private DadosPessoaisDataProvider dadosPessoaisDataProvider;
    @Autowired
    private EnderecosDataProvider enderecosDataProvider;

    @Override
    @Transactional
    public Usuario execute(Usuario usuario) {
        DadosPessoaisUtils.validarDadosPessoais(usuario);

        final Long usuarioId = usuario.getId();
        final var usuarioDB = usuariosDataProvider.findById(usuarioId);
        if (EntityStatusEnum.INATIVO.equals(usuarioDB.getStatus())) {
            throw new ValidationException(MappingMessagesEnum.MSG_ERROR_VALIDATION_ENTITY_NOT_PERMIT_OPERATION_BY_STATUS, "Editar", "Inativo");
        }
        usuario.setStatus(usuarioDB.getStatus());
        usuario.setPerfis(usuarioDB.getPerfis());

        // Salva os dados antes evitando o erro: org.hibernate.TransientPropertyValueException: Not-null property
        Endereco endereco = usuario.getDadosPessoais().getEndereco();
        endereco.setId(usuarioDB.getDadosPessoais().getEndereco().getId());
        endereco = enderecosDataProvider.save(endereco);

        DadosPessoais dadosPessoais = usuario.getDadosPessoais();
        dadosPessoais.setId(usuarioDB.getDadosPessoais().getId());
        dadosPessoais.setEndereco(endereco);
        dadosPessoais = dadosPessoaisDataProvider.save(dadosPessoais);

        usuario.setDadosPessoais(dadosPessoais);

        return usuariosDataProvider.save(usuario);
    }

}
