/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico.inscricao.estadual;

/**
 *
 * @author izaquiellopesdebessas
 */
public class IEBA extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public IEBA(String ie) {
        super(ie);
    }

    /**
     * Valida uma inscrição estadual para o estado da BA
     * 
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_BA.html"> SINTEGRA </a>
     *
     * @return verdadeiro caso a inscrição estadual seja válida para a BA, falso caso contrário.
     */
    public boolean isIEBA() {
        switch (this.getIe().length()) {
            case 8:
            {
                int[] insc = adequaStringParaIntegers(this.getIe(), 8);
                int[] inscCalc = new int[insc.length];
                int[] pesosDV2 = {7, 6, 5, 4, 3, 2};
                int[] pesosDV1 = {8, 7, 6, 5, 4, 3, 2};
                
                int modulo = 10;
                if (insc[0] == 6 || insc[0] == 7 || insc[0] == 9) {
                    modulo = 11;
                }
                
                int[] result = new int[pesosDV2.length];
                for (int i = 0; i < result.length; i++) {
                    result[i] = insc[i] * pesosDV2[i];
                }
                int soma = 0;
                for (int i = 0; i < result.length; i++) {
                    soma += result[i];
                }
                
                int resto = soma % modulo;
                int dv2 = resto;
                if (dv2 != 0) {
                    dv2 = modulo - resto;
                }
                if (dv2 != insc[7]) {
                    return false;
                }
                
                System.arraycopy(insc, 0, inscCalc, 0, pesosDV2.length);
                inscCalc[pesosDV2.length] = dv2;
                
                result = new int[pesosDV1.length];
                for (int i = 0; i < result.length; i++) {
                    result[i] = inscCalc[i] * pesosDV1[i];
                }
                soma = 0;
                for (int i = 0; i < result.length; i++) {
                    soma += result[i];
                }
                resto = soma % modulo;
                int dv1 = resto;
                if (dv1 != 0) {
                    dv1 = modulo - resto;
                }
            return dv1 == insc[6];
            }
            case 9:
            {
                int[] insc = adequaStringParaIntegers(this.getIe(), 9);
                int[] inscCalc = new int[insc.length];
                int[] pesosDV2 = {8, 7, 6, 5, 4, 3, 2};
                int[] pesosDV1 = {9, 8, 7, 6, 5, 4, 3, 2};
                
                int modulo = 10;
                if (insc[1] == 6 || insc[1] == 7 || insc[1] == 9) {
                    modulo = 11;
                }
                
                int[] result = new int[pesosDV2.length];
                for (int i = 0; i < result.length; i++) {
                    result[i] = insc[i] * pesosDV2[i];
                }
                int soma = 0;
                for (int i = 0; i < result.length; i++) {
                    soma += result[i];
                }
                int resto = soma % modulo;
                int dv2 = resto;
                if (dv2 != 0) {
                    dv2 = modulo - resto;
                }
                if (dv2 != insc[8]) {
                    return false;
                }
                
                System.arraycopy(insc, 0, inscCalc, 0, pesosDV2.length);
                inscCalc[pesosDV2.length] = dv2;
                
                result = new int[pesosDV1.length];
                for (int i = 0; i < result.length; i++) {
                    result[i] = inscCalc[i] * pesosDV1[i];
                }
                soma = 0;
                for (int i = 0; i < result.length; i++) {
                    soma += result[i];
                }
                resto = soma % modulo;
                int dv1 = resto;
                if (dv1 != 0) {
                    dv1 = modulo - resto;
                }
            return dv1 == insc[7];
            }
            default:
                return false;
        }
    }
}
