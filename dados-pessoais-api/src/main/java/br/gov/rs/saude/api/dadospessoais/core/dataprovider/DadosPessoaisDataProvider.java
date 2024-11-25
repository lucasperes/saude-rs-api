package br.gov.rs.saude.api.dadospessoais.core.dataprovider;

import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoal;
import br.gov.rs.saude.api.saude.api.core.dataprovider.IDataProviderBase;

/**
 * Interafce Data Provider para {@link DadosPessoal}
 */
public interface DadosPessoaisDataProvider extends IDataProviderBase<DadosPessoal> {

	/**
	 * Deve Salvar os {@link DadosPessoal}
	 *
	 * @param entity {@link DadosPessoal}
	 * @return {@link DadosPessoal}
	 */
	DadosPessoal save(DadosPessoal entity);
	
}
