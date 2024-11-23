CREATE SEQUENCE sch_perfis.tb_perfil_id_seq;
CREATE TABLE sch_perfis.TB_PERFIL (
                ID INTEGER NOT NULL DEFAULT nextval('sch_perfis.tb_perfil_id_seq'),
                DSC_NOME VARCHAR(60) NOT NULL,
                CONSTRAINT tb_perfil_pk PRIMARY KEY (ID)
);
ALTER SEQUENCE sch_perfis.tb_perfil_id_seq OWNED BY sch_perfis.TB_PERFIL.ID;

CREATE SEQUENCE sch_perfis.tb_usuario_id_seq;
CREATE TABLE sch_perfis.TB_USUARIO (
                ID BIGINT NOT NULL DEFAULT nextval('sch_perfis.tb_usuario_id_seq'),
                FK_DADOS_PESSOAL_ID BIGINT NOT NULL,
                DSC_STATUS VARCHAR(30) NOT NULL,
                CONSTRAINT tb_usuario_pk PRIMARY KEY (ID)
);
ALTER SEQUENCE sch_perfis.tb_usuario_id_seq OWNED BY sch_perfis.TB_USUARIO.ID;

CREATE TABLE sch_perfis.TB_USUARIO_PERFIL (
                FK_USUARIO_ID BIGINT NOT NULL,
                FK_PERFIL_ID INTEGER NOT NULL,
                CONSTRAINT tb_usuario_perfil_pk PRIMARY KEY (FK_USUARIO_ID, FK_PERFIL_ID)
);

ALTER TABLE sch_perfis.TB_USUARIO ADD CONSTRAINT tb_usuario_tb_dados_pessoal_fk
FOREIGN KEY (FK_DADOS_PESSOAL_ID)
REFERENCES sch_dados_pessoais.TB_DADOS_PESSOAL (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE sch_perfis.TB_USUARIO_PERFIL ADD CONSTRAINT tb_usuario_perfil_tb_perfil_fk
FOREIGN KEY (FK_PERFIL_ID)
REFERENCES sch_perfis.TB_PERFIL (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE sch_perfis.TB_USUARIO_PERFIL ADD CONSTRAINT tb_usuario_perfil_tb_usuario_fk
FOREIGN KEY (FK_USUARIO_ID)
REFERENCES sch_perfis.TB_USUARIO (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;