/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;


/**
 *
 * @author izaquiellopesdebessas
 */
public class EstRS extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public EstRS(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de RS
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_RS.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em RS, e falso para uma inválida.
     */
    public boolean isIERS() {
        if (this.getIe().length() != 10) {
            return false;
        }

        int[] pesos = {2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 10);

        int soma = 0;
        for (int i = 0; i < pesos.length; i++) {
            soma += insc[i] * pesos[i];
        }

        int dv = 11 - (soma % 11);
        if (dv == 10 || dv == 11) {
            dv = 0;
        }

        return dv == insc[9];
    }
}
