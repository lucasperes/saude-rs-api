package br.gov.rs.saude.api.dadospessoais.core.dataprovider;

import org.springframework.data.domain.Page;

import br.gov.rs.saude.api.dadospessoais.core.domain.DadosPessoaisFilters;
import br.gov.rs.saude.api.dadospessoais.core.domain.Usuario;
import br.gov.rs.saude.api.saude.api.core.dataprovider.IDataProviderBase;

/**
 * Interafce Data Provider para {@link Usuario}
 */
public interface UsuariosDataProvider extends IDataProviderBase<Usuario> {

	/**
	 * Deve retornar um {@link Usuario} pelo seu ID
	 *
	 * @param id {@link Long}
	 * @return {@link Usuario}
	 */
	Usuario findById(Long id);
	
	/**
	 * Deve Salvar um {@link Usuario}
	 *
	 * @param entity {@link Usuario}
	 * @return {@link Usuario}
	 */
	Usuario save(Usuario entity);
	
	/**
	 * Deve listar os {@link Usuario} com paginacao
	 * 
	 * @param filters {@link DadosPessoaisFilters}
	 * @return {@link Page} de {@link Usuario}
	 */
	Page<Usuario> list(DadosPessoaisFilters filters);
	
}
