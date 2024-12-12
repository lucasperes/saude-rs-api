package br.gov.rs.saude.api.dadospessoais.core.dataprovider;

import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoais;
import br.gov.rs.saude.api.saude.api.core.dataprovider.IDataProviderBase;

/**
 * Interafce Data Provider para {@link DadosPessoais}
 */
public interface DadosPessoaisDataProvider extends IDataProviderBase<DadosPessoais> {

	/**
	 * Deve Salvar os {@link DadosPessoais}
	 *
	 * @param entity {@link DadosPessoais}
	 * @return {@link DadosPessoais}
	 */
	DadosPessoais save(DadosPessoais entity);
	
}
