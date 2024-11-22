package br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity;

import br.gov.rs.saude.api.saude.api.core.domain.entity.AbstractEntityBase;
import br.gov.rs.saude.api.saude.api.core.utils.ConstantsUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Entity que mapeia a tabela: TB_CIDADE no schema: sch_dados_pessoais
 */
@Entity
@Getter @Setter
@Table(
	name = CidadeEntity.NAME_TABLE,
	schema = ConstantsUtils.Database.NAME_SCHEMA_DADOS_PESSOAIS
)
public class CidadeEntity extends AbstractEntityBase<Integer> {
	
	private static final long serialVersionUID = 9119800356262848646L;
	
	// NAMES COLUMNS TABLE DATABASE
	public static final String NAME_TABLE = "TB_CIDADE";
	public static final String COLUMN_NOME = "DSC_NOME";
	public static final String COLUMN_UF = "CD_UF";

	@Id
	@Column(name = COLUMN_ID, nullable = false)
	private Integer id;
	
	@NotBlank
	@Column(name = COLUMN_NOME, length = 60, nullable = false)
	private String nome;
	
	@NotBlank
	@Column(name = COLUMN_UF, length = 2, nullable = false)
	private String uf;
	
}
