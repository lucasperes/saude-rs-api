package br.gov.rs.saude.api.saude.api.core.domain.entity;

import br.gov.rs.saude.api.saude.api.core.domain.enums.global.EntityStatusEnum;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Abstrata para ser extendida pelas classes Entities JPA que controla um Status da Entidade
 * 
 * @param <ID> Tipo do Identificador da Chave Primaria da tabela no banco de dados
 */
@Getter @Setter
@MappedSuperclass
public abstract class AbstractStatusEntityBase<ID> extends AbstractEntityBase<ID> {

	private static final long serialVersionUID = -478710853877280233L;
	
	// NAMES COLUMNS TABLE DATABASE
	public static final String COLUMN_STATUS = "DSC_STATUS";
	
	@Basic
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = COLUMN_STATUS, length = 30, nullable = false)
	private EntityStatusEnum status;
	
}
