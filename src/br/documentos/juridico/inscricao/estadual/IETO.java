/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico.inscricao.estadual;


/**
 *
 * @author izaquiellopesdebessas
 */
public class IETO extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public IETO(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de TO
     * 
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_TO.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em TO, e falso para uma inválida.
     */
    public boolean isIETO() {
        if (this.getIe().length() != 11) {
            return false;
        }

        int[] insc = adequaStringParaIntegers(this.getIe(), 11);
        int[] pesos = {9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;
        for (int i = 0, j = 0; i < insc.length - 1; i++) {
            if (i != 3 && i != 4) {
                soma += pesos[j] * insc[i];
                j++;
            }
        }

        int dv = 11 - (soma % 11);
        if (soma % 11 < 2) {
            dv = 0;
        }

        return dv == insc[10];
    }

    /**
     * verifica se a inscrição estadual pertence a um produtor rural, nesse caso não se possui CGC
     * @return retorna-se true caso seja um produtor rural
     */
    public boolean isProdutorRural() {
        int[] insc = adequaStringParaIntegers(this.getIe(), 11);
        return insc[2] == 0 && insc[3] == 1;
    }

    /**
     * verifica se a inscrição estadual pertence a uma indústria ou a um comércio
     * @return retorna-se true caso seja uma indústria ou um comércio
     */
    public boolean isIndECom() {
        int[] insc = adequaStringParaIntegers(this.getIe(), 11);
        return insc[2] == 0 && insc[3] == 2;
    }

    /**
     * verifica se a inscrição estadual pertence a uma empresa rudimentar
     * @return retorna-se true caso a IE seja de uma empresa rudimentar
     */
    public boolean isEmpRudimentar() {
        int[] insc = adequaStringParaIntegers(this.getIe(), 11);
        return insc[2] == 0 && insc[3] == 3;
    }

    /**
     * verifica se a inscrição estadual pertence a uma empresa de cadastro antigo, no caso já SUSPENSA
     * @return retorna-se true caso a IE seja de uma empresa de cadastro antigo
     */
    public boolean isEmpCadAntigoSUSPENSA() {
        int[] insc = adequaStringParaIntegers(this.getIe(), 11);
        return insc[2] == 9 && insc[3] == 9;
    }
}
