/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico.inscricao.estadual;


/**
 *
 * @author izaquiellopesdebessas
 */
public class IERJ extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public IERJ(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de RJ
     * 
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_RJ.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em RJ, e falso para uma inválida.
     */
    public boolean isIERJ() {
        if (this.getIe().length() != 8) {
            return false;
        }

        int[] pesos = {2, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 8);

        int soma = 0;
        for (int i = 0; i < pesos.length; i++) {
            soma += insc[i] * pesos[i];
        }

        int dv = 11 - (soma % 11);
        if (soma % 11 <= 1) {
            dv = 0;
        }

        return dv == insc[7];
    }
}
