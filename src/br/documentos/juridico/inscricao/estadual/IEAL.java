/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico.inscricao.estadual;


/**
 *
 * @author izaquiellopesdebessas
 */
public class IEAL extends IE {

    /**
     * Construtor padrão da classe
     * 
     * @param ie inscrição estadual a ser validada
     */
    public IEAL(String ie) {
        super(ie);
    }

    /**
     * Valida se a inscrição estadual é válida para o estado de AL
     * 
     * <i> detalhes do cálculo: </i> <a href="http://www.sintegra.gov.br/Cad_Estados/cad_AL.html"> SINTEGRA </a>
     * 
     * @return retorna-se verdadeiro caso a inscrição estadual seja válida para o estado de AL, e falso, caso contrário
     */
    public boolean isIEAL() {
        if (this.getIe().length() != 9) {
            return false;
        }

        int[] pesos = {9, 8, 7, 6, 5, 4, 3, 2};
        int[] insc = adequaStringParaIntegers(this.getIe(), 9);

        int soma = 0;
        for (int i = 0; i < pesos.length; i++) {
            soma += insc[i] * pesos[i];
        }

        int dv = soma * 10 - (((soma * 10) / 11) * 11);

        return dv == insc[8];
    }

    /**
     * X – Tipo de empresa (8-Micro-Empresa)
     * @return retorna true caso seja micro empresa
     */
    public boolean isMicroEmpresa() {
        return adequaStringParaIntegers(this.getIe(), 9)[2] == 8;
    }

    /**
     * X – Tipo de empresa (5-Substituta)
     * @return retorna true caso seja empresa substituta
     */
    public boolean isEmpresaSubstituta() {
        return adequaStringParaIntegers(this.getIe(), 9)[2] == 5;
    }

    /**
     * X – Tipo de empresa (7- Micro-Empresa Ambulante)
     * @return retorna true caso seja micro empresa ambulante
     */
    public boolean isMicroEmpresaAmbulante() {
        return adequaStringParaIntegers(this.getIe(), 9)[2] == 7;
    }

    /**
     * X – Tipo de empresa (0-Normal)
     * @return retorna true caso seja micro empresa
     */
    public boolean isEmpresaNormal() {
        return adequaStringParaIntegers(this.getIe(), 9)[2] == 0;
    }

    /**
     * <h1> Verifica se a inscrição estadual instânciada é de um produtor rural </h1>
     * 
     * X – Tipo de empresa (3-Produtor Rural)
     * 
     * @return retorna-se verdadeiro caso seja produtor rural, e falso, caso contrário
     */
    public boolean isProdutorRural() {
        return adequaStringParaIntegers(this.getIe(), 9)[2] == 3;
    }
}
