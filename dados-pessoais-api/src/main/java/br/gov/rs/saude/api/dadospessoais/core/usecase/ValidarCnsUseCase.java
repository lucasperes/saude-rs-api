package br.gov.rs.saude.api.dadospessoais.core.usecase;

import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.dadospessoais.utils.CnsUtils;
import br.gov.rs.saude.api.dadospessoais.utils.messages.MappingMessagesEnum;
import br.gov.rs.saude.api.saude.api.core.exception.impl.ValidationException;
import br.gov.rs.saude.api.saude.api.core.usecase.IUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.usecase.impl.AbstractUseCaseBase;
import br.gov.rs.saude.api.saude.api.core.utils.ValidationUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe UseCase para Desativar o cadastro de um {@link Usuario}
 */
@Component
public class ValidarCnsUseCase extends AbstractUseCaseBase implements IUseCaseBase<String, Void> {

	private static final long serialVersionUID = -977893995407109187L;

	@Override
	@Transactional
	public Void execute(String cns) {
		if (ValidationUtils.isNull(cns)) {
			throw new ValidationException(MappingMessagesEnum.MSG_ERROR_VALIDATION_NULL_FIELD, "CNS");
		}

		if (!CnsUtils.isCnsValido(cns)) {
			throw new ValidationException(MappingMessagesEnum.MSG_ERROR_VALIDATION_DOCUMENT_INVALID, cns, "CNS");
		}
		return null;
	}
}
