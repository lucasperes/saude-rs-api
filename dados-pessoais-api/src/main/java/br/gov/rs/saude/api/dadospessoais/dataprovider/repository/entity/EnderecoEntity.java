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
	public static final String COLUMN_CIDADE = "FK_CIDADE_ID";
	public static final String COLUMN_LOGRADOURO = "DSC_LOGRADOURO";
	public static final String COLUMN_BAIRRO = "DSC_BAIRRO";
	public static final String COLUMN_COMPLEMENTO = "DSC_COMPLEMENTO";
	
	@Id
	@Column(name = COLUMN_ID, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = COLUMN_CEP, length = 9, nullable = false)
	private String cep;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = COLUMN_CIDADE, nullable = false)
	private CidadeEntity cidade;
	
	@NotBlank
	@Column(name = COLUMN_LOGRADOURO, length = 120, nullable = false)
	private String logradouro;
	
	@NotBlank
	@Column(name = COLUMN_BAIRRO, length = 60, nullable = false)
	private String bairro;
	
	@Column(name = COLUMN_COMPLEMENTO, length = 120)
	private String complemento;

}
