package br.gov.rs.saude.api.dadospessoais.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CnsUtils {

    public static boolean validaCns(String cns) {
        if (cns.trim().length() != 15) {
            return false;
        }

        var pis = cns.substring(0, 11);

        // Cálculo da soma com os pesos de 15 a 5
        var soma = 0;
        for (int i = 0; i < 11; i++) {
            soma += Integer.parseInt(String.valueOf(pis.charAt(i))) * (15 - i);
        }

        var resto = soma % 11;
        var dv = 11 - resto;

        if (dv == 11) {
            dv = 0;
        } else if (dv == 10) {
            // Ajuste para dv == 10
            soma += 2;
            resto = soma % 11;
            dv = 11 - resto;
        }

        var resultado = pis + (dv == 10 ? "001" : "000") + dv;

        return cns.equals(resultado);
    }

    public boolean validaCnsProv(String cns) {
        if (cns.trim().length() != 15) {
            return false;
        }

        var soma = 0;

        // Calcula a soma dos produtos dos dígitos pelos seus respectivos pesos (15 a 1)
        for (int i = 0; i < 15; i++) {
            soma += Integer.parseInt(String.valueOf(cns.charAt(i))) * (15 - i);
        }

        // Verifica se a soma é divisível por 11
        return soma % 11 == 0;
    }

    /**
     * Validação do CNS com base na regra de negócio disponiblizado pelo ESUS em:
     * https://integracao.esusab.ufsc.br/ledi/documentacao/regras/algoritmo_CNS.html
     *
     * @param cns Número do CNS
     * @return {@link Boolean}
     */
    public static boolean isCnsValido(String cns) {
        if (cns == null || cns.trim().isEmpty()) {
           return false;
        }

        char primeiroDigito = cns.trim().charAt(0);

        return switch (primeiroDigito) {
            case '1', '2' -> validaCns(cns);
            case '7', '8', '9' -> validaCnsProv(cns);
            default -> false;
        };
    }
}
