package br.gov.rs.saude.api.dadospessoais.core.dataprovider;

import br.gov.rs.saude.api.dadospessoais.core.domain.Perfil;
import br.gov.rs.saude.api.saude.api.core.dataprovider.IDataProviderBase;

/**
 * Interafce Data Provider para {@link Perfil}
 */
public interface PerfisDataProvider extends IDataProviderBase<Perfil> {

	/**
	 * Deve retornar um {@link Perfil} pelo seu ID
	 *
	 * @param id {@link Integer}
	 * @return {@link Perfil}
	 */
	Perfil findById(Integer id);
	
}
