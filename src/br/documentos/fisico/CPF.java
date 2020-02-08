/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.fisico;

/**
 *
 * @author izaquiellopesdebessas
 */
public class CPF {

    /**
     * <h1> Valida se o CPF fornecido � um CPF v�lido </h1>
     *
     * Deve-se fornecer um CPF (em string), para que este seja validado.
     *
     * @param sCpf CPF a ser validado.
     * @return verdadeiro caso o CPF fornecido for um CPF v�lido e falso caso contr�rio.
     */
    public boolean isCPF(String sCpf) {
        int[] cpf = new int[9];
        int[] pesos = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int dv1, dv2; //dv = digito verificador

        for (int i = 0, j = 8; i < sCpf.length() - 2; i++) {
            try { //monta o doc, ignora a mascara, le da esquerda para direita, e escreve da direita para esquerda
                cpf[j] = Integer.parseInt(sCpf.substring(i, i + 1));
                j--;
            } catch (NumberFormatException e) {
            }
        }
        dv1 = calculaDV(cpf, pesos);

        int[] aux = new int[10];
        aux[0] = dv1;
        cpf = tranfereConteudo(cpf, aux);

        dv2 = calculaDV(cpf, pesos);
        String dv = String.valueOf(dv1) + String.valueOf(dv2);

        if (verificaConteudoIgualVetor(cpf)) {
            return false;
        }
        return sCpf.endsWith(dv);
    }

    /**
     * Calcula o digito verificador
     *
     * @param doc CPF, vetor de inteiros contendo o CPF
     * @param pesos pesos, vetor de inteiros com valores pré-determinados de
     * acordo com sua posição no vetor
     * @return retorna-se a soma dos produtos do vetor de pesos e CPF,
     * somatório(<i>vp[i] x vc[i]</i>)
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
     * Transfere o conte�do do vetor menor para o vetor maior, atrav�s de uma opera��o nativa, System.arraycopy
     *
     * @param vMenor vetor menor
     * @param vMaior vetor maior
     * @return retorna-se o vetor maior, com o conteúdo do vetor menor.
     */
    private int[] tranfereConteudo(int[] vMenor, int[] vMaior) {
        System.arraycopy(vMenor, 0, vMaior, 1, vMenor.length);
        return vMaior;
    }

    /**
     * Verifica se o conteúdo do vetor é igual entre si
     *
     * @param vet vetor de inteiros
     * @return caso <i>v[i]</i> for diferente de <i>v[i + 1]</i>, retorna-se
     * falso, senão, ao final da comparação, retorna-se verdadeiro.
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
     * <h1> Verifica qual foi o estado que emitiu o CPF </h1>
     *
     * Alguns estados podem possuir o mesmo dígito de verificação, portanto, nem
     * sempre é possível dizer com precisão, qual o estado emissor.
     *
     * @param sCpf CPF a ser verificado
     * @return sigla, ou siglas, do estado que emitiu o CPF
     */
    public String estadoEmitente(String sCpf) {
        int[] cpf = new int[11];
        for (int i = 0; i < cpf.length; i++) {
            try {
                cpf[i] = Integer.parseInt(String.valueOf(sCpf.charAt(i)));
            } catch (NumberFormatException e) {
            }
        }
        switch (cpf[8]) {
            case 0:
                return "RS";
            case 1:
                return "GO/MT/MS/DF/TO";
            case 2:
                return "AM/AC/PA/RR/RO/AP";
            case 3:
                return "MA/CE/PI";
            case 4:
                return "RN/PB/PE/AL";
            case 5:
                return "SE/BA";
            case 6:
                return "MG";
            case 7:
                return "RJ/ES";
            case 8:
                return "SP";
            case 9:
                return "PR/SC";
            default:
                return "";
        }
    }
}
