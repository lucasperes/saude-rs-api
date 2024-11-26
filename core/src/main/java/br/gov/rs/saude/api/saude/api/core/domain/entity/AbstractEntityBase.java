package br.gov.rs.saude.api.saude.api.core.domain.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Abstrata para ser extendida pelas classes Entities JPA para padronizar o a criacao classes @Entity de tabelas
 * do banco de dados da aplicacao Saude API
 * 
 * @param <ID> Tipo do Identificador da Chave Primaria da tabela no banco de dados
 */
@Getter @Setter
@MappedSuperclass
public abstract class AbstractEntityBase<ID> implements Serializable {

	private static final long serialVersionUID = -478710853877280233L;
	
	// COLUMNS
	public static final String COLUMN_ID = "ID";
	// ATTRS
	public static final String ATTR_ALIAS_ENTITY_ID = "e.id";

	/**
	 * Deve retornar o ID da Entidade
	 * @return <ID>
	 */
	public abstract ID getId();
	
	/**
	 * Deve definir o ID da Entidade
	 * @param <ID>
	 */
	public abstract void setId(ID id);
	
	// Equals and Hashcode
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntityBase<ID> other = (AbstractEntityBase<ID>) obj;
		return Objects.equals(getId(), other.getId());
	}
	
}
