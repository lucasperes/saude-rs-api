package br.gov.rs.saude.api.saude.api.core.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Classe Abstrata para ser extendida pelas classes DTOs para transporte de dados entre os modulos da aplicacao Saude API
 *
 */
@JsonInclude(Include.NON_NULL)
public abstract class AbstractDTOBase implements Serializable {

	private static final long serialVersionUID = 5026771265852519293L;
	
}
