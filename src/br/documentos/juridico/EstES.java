/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;


/**
 *
 * @author izaquiellopesdebessas
 */
public class EstES extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public EstES(String ie) {
        super(ie);
    }

    /**
     * Verifica se uma dada inscrição estadual é válida para o estado do Espírito Santo
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_ES.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro caso a inscrição estadual seja válida no ES, e falso caso contrário
     */
    public boolean isIEES() {
        if (this.getIe().length() != 9) {
            return false;
        }

        int[] pesos = {9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 9);

        int soma = 0;
        for (int i = 0; i < pesos.length; i++) {
            soma += insc[i] * pesos[i];
        }

        int dv = soma % 11;
        if (dv < 2) {
            dv = 0;
        } else if (dv > 1) {
            dv = 11 - dv;
        }

        return dv == insc[8];
    }
}
