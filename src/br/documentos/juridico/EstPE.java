/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;

/**
 *
 * @author izaquiellopesdebessas
 */
public class EstPE extends IE {

    /**
     * Construtor padrão da classe
     *
     * @param ie inscrição estadual a ser validada
     */
    public EstPE(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de PE
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_PE.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em PE, e falso para uma inválida.
     */
    public boolean isIEPE() {
        if (this.getIe().length() == 9) {
            int[] pesosDV1 = {8, 7, 6, 5, 4, 3, 2};
            int[] pesosDV2 = {9, 8, 7, 6, 5, 4, 3, 2};
            int[] insc = adequaStringParaIntegers(this.getIe(), 9);

            int[] result = new int[pesosDV1.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = insc[i] * pesosDV1[i];
            }
            int soma = 0;
            for (int i = 0; i < result.length; i++) {
                soma += result[i];
            }
            int resto = soma % 11;
            int dv1 = 0;
            if (resto != 0 && resto != 1) {
                dv1 = 11 - resto;
            }
            if (dv1 != insc[7]) {
                return false;
            }

            result = new int[pesosDV2.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = insc[i] * pesosDV2[i];
            }
            soma = 0;
            for (int i = 0; i < result.length; i++) {
                soma += result[i];
            }
            resto = soma % 11;
            int dv2 = 0;
            if (resto != 0 && resto != 1) {
                dv2 = 11 - resto;
            }
            if (dv2 != insc[8]) {
                return false;
            } else {
                return true;
            }
        } else if (this.getIe().length() == 14) {
            int[] pesos = {5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] insc = adequaStringParaIntegers(this.getIe(), 14);
            
            int[] result = new int[pesos.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = insc[i] * pesos[i];
            }
            int soma = 0;
            for (int i = 0; i < result.length; i++) {
                soma += result[i];
            }
            int dv = 11 - (soma % 11);
            if (dv > 9) {
                dv -= 10;
            }
            if (dv != insc[13]) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
