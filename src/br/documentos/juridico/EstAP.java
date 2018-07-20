/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;


/**
 *
 * @author izaquiellopesdebessas
 */
public class EstAP extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public EstAP(String ie) {
        super(ie);
    }

    /**
     * Valida uma dada inscrição estadual para o estado do AP
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_AP.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro caso a inscrição estadual pertença ao estado do AP, e falso caso contrário
     */
    public boolean isIEAP() {
        if (this.getIe().length() != 9) {
            return false;
        }

        int[] pesos = {9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 9);
        int p = 0, d = 0;
        long lim1 = 3000000, lim2 = 3017001, lim3 = 3017000, lim4 = 3019023;

        if (insc[0] == 0 && insc[1] == 3) {
            if ((lim1 < Integer.parseInt(this.getIe().substring(0, this.getIe().length() - 1))) && (Integer.parseInt(this.getIe().substring(0, this.getIe().length() - 1)) < lim2)) {
                p = 5;
                d = 0;
            } else if ((lim3 < Integer.parseInt(this.getIe().substring(0, this.getIe().length() - 1))) && (Integer.parseInt(this.getIe().substring(0, this.getIe().length() - 1)) < lim4)) {
                p = 9;
                d = 1;
            }

            int soma = p;
            for (int i = 0; i < pesos.length; i++) {
                soma += insc[i] * pesos[i];
            }

            int dv = 11 - (soma % 11);
            if (dv == 10) {
                dv = 0;
            } else if (dv == 11) {
                dv = d;
            }

            return dv == insc[8];
        } else {
            return false;
        }
    }
}
