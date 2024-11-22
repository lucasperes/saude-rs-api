package br.gov.rs.saude.api.saude.api.core.utils.action;

/**
 * Interface Utilizada para executar actions dos Controllers API
 * 
 * @param <T>
 */
@FunctionalInterface
public interface IProcessActionAPI<T> {

	/**
	 * Deve executar uma acao e retornar uma resposta
	 * 
	 * @return <T> tipo parametrizado
	 */
	T process();
	
}
