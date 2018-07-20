/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;

/**
 *
 * @author izaquiellopesdebessas
 */
public class IE {

    private String ie;

    /**
     * Construtor padrão da classe
     *
     * @param ie inscrição estadual
     */
    public IE(String ie) {
        this.ie = ie;
    }

    /**
     * Passa a inscrição estadual de uma string para um vetor de inteiros
     *
     * <i> Mais informações, acesse: </i> <a href="http://www.sintegra.gov.br/">
     * SINTEGRA </a>
     *
     * @param ie inscrição estadual em string
     * @param tam quantidade de dígitos da inscrição estadual
     * @return inscrição estadual em vetor de inteiros
     */
    public int[] adequaStringParaIntegers(String ie, int tam) {
        int[] vet = new int[tam];
        for (int i = 0; i < vet.length; i++) {
            vet[i] = Integer.parseInt(ie.substring(i, i + 1));
        }
        return vet;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    /**
     * retorna-se a inscrição estadual
     *
     * @return string - inscrição estadual
     */
    public String getIe() {
        return ie;
    }

    /**
     * atribui-se a inscrição estadual à variável string ie
     *
     * @param ie string - inscrição estadual
     */
    public void setIe(String ie) {
        this.ie = ie;
    }
    //</editor-fold>
}
