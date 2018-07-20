/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico.inscricao.estadual;

/**
 *
 * @author izaquiellopesdebessas
 */
public class IEPR extends IE {

    /**
     * Construtor padrão da classe
     *
     * @param ie inscrição estadual a ser validada
     */
    public IEPR(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de PR
     * 
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_PR.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em PR, e falso para uma inválida.
     */
    public boolean isIEPR() {

        int[] pesosDV1 = {3, 2, 7, 6, 5, 4, 3, 2};
        int[] pesosDV2 = {4, 3, 2, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 10);

        int[] result = new int[pesosDV1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = insc[i] * pesosDV1[i];
        }
        int soma = 0;
        for (int i = 0; i < result.length; i++) {
            soma += result[i];
        }
        int dv1 = 11 - (soma % 11);
        if (dv1 == 10 || dv1 == 11) {
            dv1 = 0;
        }
        if (dv1 != insc[8]) {
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
        int dv2 = 11 - (soma % 11);
        if (dv2 == 10 || dv2 == 11) {
            dv2 = 0;
        }
        return dv2 == insc[9];
    }
}
