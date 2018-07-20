/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;

/**
 *
 * @author izaquiellopesdebessas
 */
public class EstSP extends IE {

    /**
     * Construtor padrão da classe
     *
     * @param ie inscrição estadual a ser validada
     */
    public EstSP(String ie) {
        super(ie);
    }

    /**
     * Verifica se a inscrição estadual submetida a validação pertence a um
     * produtor rural não equiparado a indústria e/ou comércio
     *
     * @return retorna-se true caso seja de um produtor rural não equiparado a
     * ind.e com. e false caso contrário, ou caso não seja de um produtor rural
     */
    public boolean isProdutorRural() {
        return this.getIe().substring(0, 1).equals("P");
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de SP
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_SP.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em SP, e falso para uma inválida.
     */
    public boolean isIESP() {
        if (!isProdutorRural()) {
            if (this.getIe().length() != 12) {
                return false;
            }

            int[] pesosDV1 = {1, 3, 4, 5, 6, 7, 8, 10};
            int[] pesosDV2 = {3, 2, 10, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] insc = adequaStringParaIntegers(this.getIe(), 12);

            int[] result = new int[pesosDV1.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = insc[i] * pesosDV1[i];
            }
            int soma = 0;
            for (int i = 0; i < result.length; i++) {
                soma += result[i];
            }
            String resto = String.valueOf(soma % 11);
            int dv1 = Integer.parseInt(resto.substring(resto.length()-1));

            if (dv1 != insc[8]) {
                return false;
            }
            result = new int[pesosDV2.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = insc[i] * pesosDV2[i];
            }
            soma = 0;
            for (int i = 0; i < result.length; i++) {
                soma += result[i];
            }
            resto = String.valueOf(soma % 11);
            int dv2 = Integer.parseInt(resto.substring(resto.length()-1));

            return dv2 == insc[11];

        } else if (isProdutorRural()) {

            int[] pesosDV = {1, 3, 4, 5, 6, 7, 8, 10};
            int[] insc = adequaStringParaIntegers(this.getIe().substring(1), 12);

            int[] result = new int[pesosDV.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = insc[i] * pesosDV[i];
            }
            int soma = 0;
            for (int i = 0; i < result.length; i++) {
                soma += result[i];
            }
            String resto = String.valueOf(soma % 11);
            int dv = Integer.parseInt(resto.substring(resto.length()-1));

            return dv == insc[8];
        } else {
            return false;
        }
    }
}
