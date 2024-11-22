CREATE TABLE sch_dados_pessoais.TB_CIDADE (
                ID INTEGER NOT NULL,
                DSC_NOME VARCHAR(60) NOT NULL,
                CD_UF VARCHAR NOT NULL,
                CONSTRAINT tb_cidade_pk PRIMARY KEY (ID)
);

CREATE SEQUENCE sch_dados_pessoais.tb_endereco_id_seq;
CREATE TABLE sch_dados_pessoais.TB_ENDERECO (
                ID BIGINT NOT NULL DEFAULT nextval('sch_dados_pessoais.tb_endereco_id_seq'),
                NUM_CEP VARCHAR(9) NOT NULL,
                FK_CIDADE_ID INTEGER NOT NULL,
                DSC_LOGRADOURO VARCHAR(120) NOT NULL,
                DSC_BAIRRO VARCHAR(60) NOT NULL,
                DSC_COMPLEMENTO VARCHAR(120),
                CONSTRAINT tb_endereco_pk PRIMARY KEY (ID)
);
ALTER SEQUENCE sch_dados_pessoais.tb_endereco_id_seq OWNED BY sch_dados_pessoais.TB_ENDERECO.ID;

CREATE SEQUENCE sch_dados_pessoais.tb_dados_pessoal_id_seq;
CREATE TABLE sch_dados_pessoais.TB_DADOS_PESSOAL (
                ID BIGINT NOT NULL DEFAULT nextval('sch_dados_pessoais.tb_dados_pessoal_id_seq'),
                DSC_NOME_COMPLETO VARCHAR(60) NOT NULL,
                DSC_NOME_SOCIAL VARCHAR(80),
                DT_NASCIMENTO DATE NOT NULL,
                SGL_SEXO VARCHAR(2) NOT NULL,
                NUM_CPF VARCHAR(14) NOT NULL,
                NUM_RG VARCHAR(15) NOT NULL,
                NUM_CNS VARCHAR(15) NOT NULL,
                DSC_NOME_MAE VARCHAR(60) NOT NULL,
                DSC_NOME_PAI VARCHAR(60),
                NUM_TELEFONE VARCHAR(20) NOT NULL,
                FK_ENDERECO_ID BIGINT NOT NULL,
                CONSTRAINT tb_dados_pessoal_pk PRIMARY KEY (ID)
);
ALTER SEQUENCE sch_dados_pessoais.tb_dados_pessoal_id_seq OWNED BY sch_dados_pessoais.TB_DADOS_PESSOAL.ID;

ALTER TABLE sch_dados_pessoais.TB_ENDERECO ADD CONSTRAINT tb_endereco_tb_cidade_fk
FOREIGN KEY (FK_CIDADE_ID)
REFERENCES sch_dados_pessoais.TB_CIDADE (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE sch_dados_pessoais.TB_DADOS_PESSOAL ADD CONSTRAINT tb_dados_pessoal_tb_endereco_fk
FOREIGN KEY (FK_ENDERECO_ID)
REFERENCES sch_dados_pessoais.TB_ENDERECO (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

CREATE UNIQUE INDEX tb_dados_pessoal_cpf_unq
 ON sch_dados_pessoais.TB_DADOS_PESSOAL
 ( NUM_CPF );

CREATE UNIQUE INDEX tb_dados_pessoal_rg_unq
 ON sch_dados_pessoais.TB_DADOS_PESSOAL
 ( NUM_RG );

CREATE UNIQUE INDEX tb_dados_pessoal_cns_unq
 ON sch_dados_pessoais.TB_DADOS_PESSOAL
 ( NUM_CNS );