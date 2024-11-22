package br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity;

import br.gov.rs.saude.api.saude.api.core.domain.entity.AbstractEntityBase;
import br.gov.rs.saude.api.saude.api.core.utils.ConstantsUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Entity que mapeia a tabela: TB_PERFIL no schema: sch_perfis
 */
@Entity
@Getter @Setter
@Table(
	name = PerfilEntity.NAME_TABLE,
	schema = ConstantsUtils.Database.NAME_SCHEMA_PERFIS
)
public class PerfilEntity extends AbstractEntityBase<Integer> {

	private static final long serialVersionUID = 8117610879521855465L;

	// NAMES COLUMNS DATABASE
	public static final String NAME_TABLE = "TB_PERFIL";
	public static final String COLUMN_NOME = "DSC_NOME";
	
	@Id
	@Column(name = COLUMN_ID, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(name = COLUMN_NOME, length = 60, nullable = false)
	private String nome;
	
}
