/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico.inscricao.estadual;


/**
 *
 * @author izaquiellopesdebessas
 */
public class IESE extends IE {

    /**
     * Construtor padrão da classe
     *
     * @param ie inscrição estadual a ser validada
     */
    public IESE(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de SE
     * 
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_SE.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em SE, e falso para uma inválida.
     */
    public boolean isIESE() {
        if (this.getIe().length() != 9) {
            return false;
        }

        int[] pesos = {9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 9);

        int soma = 0;
        for (int i = 0; i < pesos.length; i++) {
            soma += insc[i] * pesos[i];
        }

        int dv = 11 - (soma % 11);
        if (dv == 10 || dv == 11) {
            dv = 0;
        }

        return dv == insc[8];
    }
}
