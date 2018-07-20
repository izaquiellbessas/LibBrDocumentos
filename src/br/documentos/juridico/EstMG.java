/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;


/**
 *
 * @author izaquiellopesdebessas
 */
public class EstMG extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public EstMG(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de MG
     * <br/><br/>
     * <i> Detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_MG.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro para uma inscrição estadual válida em MG, e falso para uma inválida.
     */
    public boolean isIEMG() {
        if (this.getIe().length() != 13) {
            return false;
        }

        int[] pesosDV1 = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        int[] pesosDV2 = {3, 2, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequacaoListaParaDV1(this.getIe());

        int[] result = new int[13];
        for (int i = 0; i < pesosDV1.length; i++) {
            result[i] = insc[i] * pesosDV1[i];
        }

        int sum = somaAlgarismos(result);
        int d1 = proxDezena(sum) - sum;

        insc = adequacaoListaParaDV2(insc);
        insc[11] = d1;

        for (int i = 0; i < pesosDV2.length; i++) {
            result[i] = insc[i] * pesosDV2[i];
        }

        int div = (somaResultados(result) % 11);
        int d2 = 0;
        if (div > 1) {
            d2 = (11 - div);
        }

        return this.getIe().endsWith(String.valueOf(d1) + String.valueOf(d2));
    }

    /**
     * Realiza-se a adequação necessária na inscrição estadual para se encontrar o primeiro dígito verificador (DV1)
     * @param str passa-se uma inscrição estadual (somente números, sem máscara)
     * @return retorna-se um vetor de inteiros já adequado para a soma do primeiro dígito verificador
     */
    private int[] adequacaoListaParaDV1(String str) {
        int[] vet = new int[12];

        for (int i = 0; i < vet.length; i++) {
            vet[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        vet[vet.length - 2] = 0;
        for (int i = vet.length - 1; i > 3; i--) {
            vet[i] = vet[i - 1];
        }
        vet[3] = 0;

        return vet;
    }

    /**
     * Realiza a adequação necessária para se trabalhar com a verificação do segundo dígito verificador (DV2)
     * @param vet vetor contendo a inscrição estadual
     * @return retorna-se o DV2
     */
    private int[] adequacaoListaParaDV2(int[] vet) {
        for (int i = 3; i < vet.length - 1; i++) {
            vet[i] = vet[i + 1];
        }
        return vet;
    }

    /**
     * Soma-se os algorismos contidos no vetor, não cada posição, mas sim cada dígito do vetor
     * @param vet vetor contendo os valores os quais deseja-se obter a soma
     * @return soma dos algarismos presentes no vetor passado por parâmetro
     */
    private int somaAlgarismos(int[] vet) {
        int result = 0;

        for (int i = 0; i < vet.length; i++) {
            if (vet[i] > 9) {
                result += somaAlgorismos(vet[i]);
            } else {
                result += vet[i];
            }
        }

        return result;
    }

    /**
     * Passa-se um número inteiro com mais de um dígito e obtem-se a soma de seus dígitos
     * @param num número inteiro, o qual deseja-se saber quanto é a soma de seus dígitos
     * @return soma dos dígitos do número passado por parâmetro
     */
    private int somaAlgorismos(int num) {
        String sVet = String.valueOf(num);
        int[] nVet = new int[sVet.length()];
        num = 0;

        for (int i = 0; i < sVet.length(); i++) {
            nVet[i] = Integer.parseInt(sVet.substring(i, i + 1));
        }
        for (int i = 0; i < nVet.length; i++) {
            num += nVet[i];
        }

        return num;
    }

    /**
     * Soma-se os valores contidos na lista de inteiros
     * @param vet vetor/lista com números inteiros
     * @return retorna-se a soma da lista de inteiros que é passada por parâmetros
     */
    private int somaResultados(int[] vet) {
        int result = 0;
        for (int i = 0; i < vet.length; i++) {
            result += vet[i];
        }
        return result;
    }

    /**
     * Fornece-se um determinado número e obtem-se a dezena que o segue (próxima dezena deste número)
     * @param d este número faz com que se retorne qual é a próxima dezena
     * @return dezena seguinte a 'd'
     */
    private int proxDezena(int d) {
        while (d % 10 != 0) {
            d++;
        }
        return d;
    }
}
