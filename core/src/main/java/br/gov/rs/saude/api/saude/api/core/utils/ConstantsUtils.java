package br.gov.rs.saude.api.saude.api.core.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConstantsUtils {
	
	public static final class Database {
		public static final String NAME_SCHEMA_DADOS_PESSOAIS = "sch_dados_pessoais";
		public static final String NAME_SCHEMA_PERFIS = "sch_perfis";
		public static final String NAME_SCHEMA_LOCALIDADES = "sch_localidades";
		public static final String NAME_SCHEMA_AGRUPAMENTOS = "sch_agrupamentos";
	}
	
	public static final class Pattern {
		public static final String DATE_BRAZILIAN = "dd/MM/yyyy";
	}

}
