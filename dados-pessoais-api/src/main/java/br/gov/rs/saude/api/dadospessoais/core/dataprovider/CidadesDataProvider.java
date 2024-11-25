package br.gov.rs.saude.api.dadospessoais.core.dataprovider;

import br.gov.rs.saude.api.dadospessoais.core.domain.Cidade;
import br.gov.rs.saude.api.saude.api.core.dataprovider.IDataProviderBase;

/**
 * Interafce Data Provider para {@link Cidade}
 */
public interface CidadesDataProvider extends IDataProviderBase<Cidade> {

	/**
	 * Deve retornar uma {@link Cidade} pelo seu ID
	 *
	 * @param id {@link Integer}
	 * @return {@link Cidade}
	 */
	Cidade findById(Integer id);
	
}
