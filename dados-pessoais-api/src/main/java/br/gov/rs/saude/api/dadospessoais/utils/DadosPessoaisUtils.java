package br.gov.rs.saude.api.dadospessoais.utils;

import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.dadospessoais.utils.messages.MappingMessagesEnum;
import br.gov.rs.saude.api.saude.api.core.exception.impl.ValidationException;
import br.gov.rs.saude.api.saude.api.core.utils.ValidationUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DadosPessoaisUtils {

    /**
     * Valida as regras de insert/update de um {@link Usuario}
     * @param usuario Dados do {@link Usuario} a serem validados
     */
    public static void validarDadosPessoais(Usuario usuario) {
        final String cpf = usuario.getDadosPessoais().getCpf();
        if (!ValidationUtils.isCPFValido(cpf)) {
            throw new ValidationException(MappingMessagesEnum.MSG_ERROR_VALIDATION_DOCUMENT_INVALID, cpf, "CPF");
        }

        final String cns = usuario.getDadosPessoais().getCns();
        if (!CnsUtils.isCnsValido(cns)) {
            throw new ValidationException(MappingMessagesEnum.MSG_ERROR_VALIDATION_DOCUMENT_INVALID, cns, "CNS");
        }
    }

}
