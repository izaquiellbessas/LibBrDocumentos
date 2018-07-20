/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;


/**
 *
 * @author izaquiellopesdebessas
 */
public class EstRR extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public EstRR(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de RR
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_RR.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em RR, e falso para uma inválida.
     */
    public boolean isIERR() {
        if (this.getIe().length() != 9) {
            return false;
        }

        int[] insc = adequaStringParaIntegers(this.getIe(), 9);

        if (insc[0] != 2 && insc[1] != 4) {
            return false;
        }

        int soma = 0;
        for (int i = 1; i < 8; i++) {
            soma += insc[i - 1] * i;
        }

        int dv = soma % 9;

        return dv == insc[8];
    }
}
