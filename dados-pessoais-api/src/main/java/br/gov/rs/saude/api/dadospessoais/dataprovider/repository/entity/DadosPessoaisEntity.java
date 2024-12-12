package br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity;

import java.time.LocalDate;

import org.hibernate.annotations.Type;

import br.gov.rs.saude.api.saude.api.core.domain.entity.AbstractEntityBase;
import br.gov.rs.saude.api.saude.api.core.domain.entity.jpa.types.global.SexoEnumJpaType;
import br.gov.rs.saude.api.saude.api.core.domain.enums.global.SexoEnum;
import br.gov.rs.saude.api.saude.api.core.utils.ConstantsUtils;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Entity que mapeia a tabela: TB_DADOS_PESSOAL no schema: sch_dados_pessoais
 */
@Entity
@Getter @Setter
@Table(
	name = DadosPessoaisEntity.NAME_TABLE,
	schema = ConstantsUtils.Database.NAME_SCHEMA_DADOS_PESSOAIS
)
public class DadosPessoaisEntity extends AbstractEntityBase<Long> {

	private static final long serialVersionUID = 1637784941167691714L;

	// NAMES COLUMNS TABLE DATABASE
	public static final String NAME_TABLE = "TB_DADOS_PESSOAIS";
	public static final String COLUMN_NOME_COMPLETO = "DSC_NOME_COMPLETO";
	public static final String COLUMN_NOME_SOCIAL = "DSC_NOME_SOCIAL";
	public static final String COLUMN_DATA_NASCIMENTO = "DT_NASCIMENTO";
	public static final String COLUMN_SEXO = "SGL_SEXO";
	public static final String COLUMN_CPF = "NUM_CPF";
	public static final String COLUMN_RG = "NUM_RG";
	public static final String COLUMN_CNS = "NUM_CNS";
	public static final String COLUMN_NOME_MAE = "DSC_NOME_MAE";
	public static final String COLUMN_NOME_PAI = "DSC_NOME_PAI";
	public static final String COLUMN_TELEFONE = "NUM_TELEFONE";
	public static final String COLUMN_ENDERECO = "FK_ENDERECO_ID";
	
	@Id
	@Column(name = COLUMN_ID, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = COLUMN_NOME_COMPLETO, length = 60, nullable = false)
	private String nomeCompleto;
	
	@Column(name = COLUMN_NOME_SOCIAL, length = 60)
	private String nomeSocial;
	
	@NotNull
	@Column(name = COLUMN_DATA_NASCIMENTO, nullable = false)
	private LocalDate dataNascimento;
	
	@Basic
	@NotNull
	@Type(value = SexoEnumJpaType.class)
	@Column(name = COLUMN_SEXO, length = 2, nullable = false)
	private SexoEnum sexo;
	
	@NotBlank
	@Column(name = COLUMN_CPF, length = 14, unique = true, nullable = false)
	private String cpf;
	
	@NotBlank
	@Column(name = COLUMN_RG, length = 15, unique = true, nullable = false)
	private String rg;
	
	@NotBlank
	@Column(name = COLUMN_CNS, length = 15, unique = true, nullable = false)
	private String cns;
	
	@NotBlank
	@Column(name = COLUMN_NOME_MAE, length = 60, nullable = false)
	private String nomeMaeCompleto;
	
	@Column(name = COLUMN_NOME_PAI, length = 60)
	private String nomePaiCompleto;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = COLUMN_ENDERECO, nullable = false)
	private EnderecoEntity endereco;
	
	@NotBlank
	@Column(name = COLUMN_TELEFONE, length = 20, nullable = false)
	private String telefone;
	
}
