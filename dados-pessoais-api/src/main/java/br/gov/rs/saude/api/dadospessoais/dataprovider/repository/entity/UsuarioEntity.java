package br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity;

import br.gov.rs.saude.api.saude.api.core.domain.entity.AbstractStatusEntityBase;
import br.gov.rs.saude.api.saude.api.core.utils.ConstantsUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Entity que mapeia a tabela: TB_USUARIO no schema: sch_perfis
 */
@Entity
@Getter @Setter
@Table(
	name = UsuarioEntity.NAME_TABLE,
	schema = ConstantsUtils.Database.NAME_SCHEMA_PERFIS
)
public class UsuarioEntity extends AbstractStatusEntityBase<Long> {

	private static final long serialVersionUID = 1634447329861024317L;

	// NAMES COLUMNS TABLE DATABASE
	public static final String NAME_TABLE = "TB_USUARIO";
	public static final String COLUMN_DADOS_PESSOAL = "FK_DADOS_PESSOAL_ID";
	public static final String COLUMN_PERFIL = "FK_PERFIL_ID";
	public static final String COLUMN_IS_ATIVO = "IS_ATIVO";
	
	@Id
	@Column(name = COLUMN_ID, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = COLUMN_DADOS_PESSOAL, nullable = false)
	private DadosPessoalEntity dadosPessoal;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = COLUMN_PERFIL, nullable = false)
	private PerfilEntity perfil;
	
}
