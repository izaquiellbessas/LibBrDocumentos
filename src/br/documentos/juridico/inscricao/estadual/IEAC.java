/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico.inscricao.estadual;


/**
 *
 * @author izaquiellopesdebessas
 */
public class IEAC extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada.
     */
    public IEAC(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual passada é válida para o estado do AC
     * 
     * <i> detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_AC.html"> SINTEGRA </a>
     * 
     * @return verdadeiro caso a inscrição estadual seja válida no estado do AC, e falso caso contrário
     */
    public boolean isIEAC() {
        if (this.getIe().length() != 13) {
            return false;
        }

        int[] pesosDV1 = {4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesosDV2 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 13);

        if (!(insc[0] == 0 && insc[1] == 1)) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < pesosDV1.length; i++) {
            soma += insc[i] * pesosDV1[i];
        }
        int dv1 = (11 - (soma % 11));
        if (dv1 == 10 || dv1 == 11) {
            dv1 = 0;
        }
        if (!(dv1 == insc[11])) {
            return false;
        } else {
            soma = 0;

            for (int i = 0; i < pesosDV2.length; i++) {
                soma += insc[i] * pesosDV2[i];
            }
            int dv2 = (11 - (soma % 11));
            if (dv2 == 10 || dv2 == 11) {
                dv2 = 0;
            }
            return dv2 == insc[12];
        }
    }
}
