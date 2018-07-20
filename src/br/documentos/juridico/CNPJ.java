/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;

/**
 *
 * @author izaquiellopesdebessas
 */
public class CNPJ {

    /**
     * <h1> Valida se o CNPJ fornecido é um CNPJ válido </h1>
     * 
     * Deve-se fornecer um CNPJ (em string), para que este seja validado.
     * 
     * @param sCnpj CNPJ a ser validado.
     * @return verdadeiro caso o CNPJ fornecido for um CNPJ válido e falso caso não seja válido.
     */
    public boolean isCNPJ(String sCnpj) {
        int[] cnpj = new int[12];
        int[] pesos = {9, 8, 7, 6, 5, 4, 3, 2, 9, 8, 7, 6, 5};
        int dv1, dv2, dig8;

        for (int i = 0, j = 11; i < sCnpj.length() - 2; i++) {
            try { //monta o doc, ignora a mascara, le da esq para dir, e escreve da dir para esq
                cnpj[j] = Integer.parseInt(sCnpj.substring(i, i + 1));
                j--;
            } catch (NumberFormatException e) {
            }
        }

        dig8 = oitavoDigito(cnpj);
        if (cnpj[4] != dig8) {
            return false;
        }
        dv1 = calculaDV(cnpj, pesos);

        int[] aux = new int[13];
        aux[0] = dv1;
        cnpj = tranfereConteudo(cnpj, aux);

        dv2 = calculaDV(cnpj, pesos);
        String dv = String.valueOf(dv1) + String.valueOf(dv2);

        if (verificaConteudoIgualVetor(cnpj)) {
            return false;
        }
        return sCnpj.endsWith(dv);
    }

    /**
     * Calcula o dígito verificador
     * 
     * @param doc CNPJ, vetor de inteiros contendo o CNPJ
     * @param pesos pesos, vetor de inteiros com valores pré-determinados de acordo com sua posição no vetor
     * @return retorna-se a soma dos produtos do vetor de pesos e CNPJ, somatório(<i>vp[i] x vc[i]</i>)
     */
    private int calculaDV(int[] doc, int[] pesos) {
        int soma = 0;
        for (int i = 0; i < doc.length; i++) {
            soma += doc[i] * pesos[i];
        }
        soma %= 11;
        if (soma == 10) {
            soma = 0;
        }
        return soma;
    }

    /**
     * Cálculo do oitavo dígito
     * 
     * @param setePs CNPJ passado em um momento específico do cálculo de validação do mesmo.
     * @return retorna-se o oitavo dígito do CNPJ
     */
    private int oitavoDigito(int[] setePs) {
        int[] pesos = {2, 1, 2, 1, 2, 1, 2};
        int soma = 0;

        for (int i = 0, j = setePs.length - 1; i <= 6; i++, j--) {
            int num = setePs[j] * pesos[i];
            if (num > 9) {
                num = somaDoisDigitos(num);
            }
            soma += num;
        }

        return 10 - soma % 10;
    }

    /**
     * Este método verifica se o conteúdo do vetor é igual
     * 
     * @param vet vetor de inteiros
     * @return caso <i>v[i]</i> for diferente de <i>v[i+1]</i>, retorna-se falso, caso todos forem 
     * iguais entre si, retorna-se verdadeiro
     */
    private boolean verificaConteudoIgualVetor(int[] vet) {
        for (int i = 0; i < vet.length - 1; i++) {
            if (vet[i] != vet[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Transfere o conteúdo do vetor menor para o vetor maior, executando a função nativa, System.arraycopy
     * 
     * @param menor vetor menor
     * @param maior vetor maior
     * @return retorna-se o vetor maior, com o conteúdo do vetor menor inserido neste.
     */
    private int[] tranfereConteudo(int[] menor, int[] maior) {
        System.arraycopy(menor, 0, maior, 1, menor.length);
        return maior;
    }

    /**
     * Soma dois dígitos, deve-se passar um número (int), maior que nove e menor que cem, os algarismos deste
     * serão somados.
     * 
     * @param num Número de dois dígitos
     * @return Soma dos dígitos do número passado entre parâmetros
     */
    private int somaDoisDigitos(int num) {
        String s = String.valueOf(num);
        return Integer.parseInt(s.substring(0, 1)) + Integer.parseInt(s.substring(1, 2));
    }
}
