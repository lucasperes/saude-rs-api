package br.gov.rs.saude.api.saude.api.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Classe Utilitaria para auxiliar em metodos na Aplicacao
 */
public class ApplicationHelper {
	
	public static String extractStackTrace(Exception err) {
		String trace = null;
		if(err != null) {
			StringWriter writer = new StringWriter();
			PrintWriter print = new PrintWriter(writer);
			err.printStackTrace(print);
			
			trace = writer.toString();
		}
		return trace;
	}

}
