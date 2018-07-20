/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;


/**
 *
 * @author izaquiellopesdebessas
 */
public class EstCE extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public EstCE(String ie) {
        super(ie);
    }

    /**
     * Valida se uma inscrição estadual é uma inscrição válida no estado do CE
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_CE.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro caso a inscrição estadual seja válida no estado do CE, e falso caso contrário
     */
    public boolean isIECE() {
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
        if (11 - (soma % 11) == 10 || 11 - (soma % 11) == 11) {
            dv = 0;
        }

        return insc[8] == dv;
    }
}
