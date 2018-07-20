/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico.inscricao.estadual;


/**
 *
 * @author izaquiellopesdebessas
 */
public class IEGO extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public IEGO(String ie) {
        super(ie);
    }

    /**
     * Verifica se a inscrição estadual é válida para o estado de Goiás
     * 
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_GO.html"> SINTEGRA </a>
     * 
     * @return true caso a inscrição seja válida e false caso contrário
     */
    public boolean isIEGO() {
        if (this.getIe().length() != 9) {
            return false;
        }

        int[] pesos = {9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 9);

        if ((insc[0] == 1 && insc[1] == 0) || (insc[0] == 1 && insc[1] == 1) || (insc[0] == 1 && insc[1] == 5)) {
            int soma = 0;
            for (int i = 0; i < pesos.length; i++) {
                soma += insc[i] * pesos[i];
            }

            int resto = soma % 11;
            int dv = 0;
            if (resto == 1 && Integer.parseInt(this.getIe().substring(0, this.getIe().length() - 1)) <= 10119997) {
                dv = 1;
            } else if (resto == 1 && Integer.parseInt(this.getIe().substring(0, this.getIe().length() - 1)) > 10119997) {
                dv = 0;
            } else if (resto != 1 && resto != 0) {
                dv = 11 - resto;
            }

            if (this.getIe().substring(0, this.getIe().length() - 1).contains("11094402")) {
                if (insc[8] == 0 || insc[8] == 1) {
                    return true;
                }
            }

            return dv == insc[8];
        } else {
            return false;
        }
    }
}
