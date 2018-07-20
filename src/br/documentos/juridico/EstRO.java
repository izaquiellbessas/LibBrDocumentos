/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;

/**
 *
 * @author izaquiellopesdebessas
 */
public class EstRO extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public EstRO(String ie) {
        super(ie);
    }
    
    /**
     * Valida se a inscrição estadual é válida para o estado de RO
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_RO.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em RO, e falso para uma inválida.
     */
    public boolean isIERO() {
        if (this.getIe().length() != 14) {
            return false;
        }
        
        int[] pesosDV = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 14);
        
        int[] result = new int[pesosDV.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = insc[i] * pesosDV[i];
        }
        int soma = 0;
        for (int i = 0; i < result.length; i++) {
            soma += result[i];
        }
        int resto = soma % 11;
        int dv = 11 - resto;
        if (dv == 10 || dv == 11) {
            dv -= 10;
        }
        
        return dv == insc[13];
    }
}
