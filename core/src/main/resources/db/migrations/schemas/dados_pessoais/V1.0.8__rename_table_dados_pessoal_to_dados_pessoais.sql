ALTER TABLE sch_dados_pessoais.tb_dados_pessoal RENAME TO tb_dados_pessoais;
ALTER TABLE sch_perfis.tb_usuario DROP CONSTRAINT tb_usuario_tb_dados_pessoal_fk;
ALTER TABLE sch_perfis.tb_usuario ADD CONSTRAINT tb_usuario_tb_dados_pessoais_fk FOREIGN KEY (id) REFERENCES sch_dados_pessoais.tb_dados_pessoais(id);
