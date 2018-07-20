/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;


/**
 *
 * @author izaquiellopesdebessas
 */
public class EstDF extends IE {

    /**
     *
     * @param ie inscrição estadual a ser validada
     */
    public EstDF(String ie) {
        super(ie);
    }

    /**
     * Verifica se uma dada inscrição estadual é válida ou não no Distrito Federal
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_DF.html" > SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro caso a inscrição estadual seja válida e falso caso contrário.
     */
    public boolean isIEDF() {
        if (this.getIe().length() != 13) {
            return false;
        }

        int[] pesosDV1 = {4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesosDV2 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 13);

        if (insc[0] == 0 && insc[1] == 7) {

            int soma = 0;
            for (int i = 0; i < pesosDV1.length; i++) {
                soma += insc[i] * pesosDV1[i];
            }

            int dv1 = 11 - (soma % 11);
            if (dv1 == 10 || dv1 == 0) {
                dv1 = 0;
            }

            if (dv1 == insc[11]) {

                soma = 0;
                for (int i = 0; i < pesosDV2.length; i++) {
                    soma += insc[i] * pesosDV2[i];
                }

                int dv2 = 11 - (soma % 11);
                if (dv2 == 10 || dv2 == 11) {
                    dv2 = 0;
                }

                return dv2 == insc[12];
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    /**
     * Verifica se a inscrição estadual pertence a matriz ou a filial
     * 
     * @return retorna-se verdadeiro caso a inscrição estadual seja da matriz, falso caso não seja.
     */
    public boolean isMatriz() {
        int[] insc = adequaStringParaIntegers(this.getIe(), 13);
        if (insc[8] == 0 && insc[9] == 0 && insc[10] == 1) {
            return true;
        } else {
            return false;
        }
    }
}
