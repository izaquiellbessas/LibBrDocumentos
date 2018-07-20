/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;


/**
 *
 * @author izaquiellopesdebessas
 */
public class EstAM extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public EstAM(String ie) {
        super(ie);
    }

    /**
     * Valida a inscrição estadual para o estado do AM
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_AM.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro caso a inscrição estadual seja válida para o estado do AM, e falso caso contrário
     */
    public boolean isIEAM() {
        if (this.getIe().length() != 9) {
            return false;
        }

        int[] pesos = {9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 9);

        int soma = 0;
        for (int i = 0; i < pesos.length; i++) {
            soma += pesos[i] * insc[i];
        }

        int dv;
        if (soma < 11) {
            dv = 11 - soma;
        } else {
            if (soma % 11 <= 1) {
                dv = 0;
            } else {
                dv = 11 - (soma % 11);
            }
        }

        return dv == insc[8];
    }
}
