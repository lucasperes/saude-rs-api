package br.gov.rs.saude.api.saude.api.core.usecase;

/**
 * Interface Base para ser implementadas nos modulos de APIs na camada de Use Cases
 *
 * @param <E> Parametros de Entrada = Request, DTO, Entity
 * @param <S> Resultado de Saida = Response, DTO, Entity
 */
@FunctionalInterface
public interface IUseCaseBase<E, S> {

	/**
	 * Deve executar uma acao e retornar uma resposta
	 *
	 * @param request <E>
	 * @return <S>
	 */
	S execute(E request);
	
}
