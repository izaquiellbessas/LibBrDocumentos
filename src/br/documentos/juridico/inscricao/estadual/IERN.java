/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico.inscricao.estadual;


/**
 *
 * @author izaquiellopesdebessas
 */
public class IERN extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public IERN(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de RN
     * 
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_RN.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em RN, e falso para uma inválida.
     */
    public boolean isIERN() {
        if (this.getIe().length() == 9 || this.getIe().length() == 10) {
            int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] insc = adequaStringParaIntegers(this.getIe(), this.getIe().length());

            int j = 0;
            if (insc.length == 9) {
                j = 1;
            }

            int soma = 0;
            for (int i = 0; i < insc.length - 1; i++) {
                soma += pesos[j] * insc[i];
                j++;
            }

            int dv = ((soma * 10) % 11);
            if (dv == 10) {
                dv = 0;
            }
            return dv == insc[insc.length - 1];
        } else {
            return false;
        }
    }
}
