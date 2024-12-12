package br.gov.rs.saude.api.dadospessoais.dataprovider.repository.entity;

import br.gov.rs.saude.api.saude.api.core.domain.entity.AbstractEntityBase;
import br.gov.rs.saude.api.saude.api.core.utils.ConstantsUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Entity que mapeia a tabela: TB_ENDERECO no schema: sch_dados_pessoais
 */
@Entity
@Getter @Setter
@Table(
	name = EnderecoEntity.NAME_TABLE,
	schema = ConstantsUtils.Database.NAME_SCHEMA_DADOS_PESSOAIS
)
public class EnderecoEntity extends AbstractEntityBase<Long> {
	
	private static final long serialVersionUID = -8958206681131021332L;
	
	// NAMES COLUMNS TABLE DATABASE
	public static final String NAME_TABLE = "TB_ENDERECO";
	public static final String COLUMN_CEP = "NUM_CEP";
	public static final String COLUMN_LOGRADOURO = "DSC_LOGRADOURO";
	public static final String COLUMN_BAIRRO = "DSC_BAIRRO";
	public static final String COLUMN_COMPLEMENTO = "DSC_COMPLEMENTO";
	public static final String COLUMN_MUNICIPIO = "DSC_MUNICIPIO_RESIDENCIA";
	public static final String COLUMN_UF = "SG_UF";
	
	@Id
	@Column(name = COLUMN_ID, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = COLUMN_CEP, length = 9, nullable = false)
	private String cep;
	
	@NotBlank
	@Column(name = COLUMN_LOGRADOURO, length = 120, nullable = false)
	private String logradouro;
	
	@NotBlank
	@Column(name = COLUMN_BAIRRO, length = 60, nullable = false)
	private String bairro;
	
	@Column(name = COLUMN_COMPLEMENTO, length = 120)
	private String complemento;

	@NotBlank
	@Column(name = COLUMN_MUNICIPIO, length = 300, nullable = false)
	private String nomeMunicipio;

	@NotBlank
	@Column(name = COLUMN_UF, length = 2, nullable = false)
	private String uf;

}
