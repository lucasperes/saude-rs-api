package br.gov.rs.saude.api.dadospessoais.core.dataprovider;

import br.gov.rs.saude.api.dadospessoais.core.domain.Endereco;
import br.gov.rs.saude.api.saude.api.core.dataprovider.IDataProviderBase;

/**
 * Interafce Data Provider para {@link Endereco}
 */
public interface EnderecosDataProvider extends IDataProviderBase<Endereco> {

	/**
	 * Deve Salvar o {@link Endereco}
	 *
	 * @param entity {@link Endereco}
	 * @return {@link Endereco}
	 */
	Endereco save(Endereco entity);
	
}
