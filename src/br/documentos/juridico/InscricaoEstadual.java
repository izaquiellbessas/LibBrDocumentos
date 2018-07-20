/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico;

/**
 *
 * @author izaquiellopesdebessas
 */
public class InscricaoEstadual {

    private String estado;
    private String ie;

    /**
     * Construtor padrão da classe 
     * <br/><br/> 
     * 
     * Deve-se passar a sigla correspondente do estado ao qual se deseja validar a inscrição estadual,
     * seguido da inscrição estadual a ser validada.
     * <br/><br/>
     * 
     * <i> Para maiores informações acesse: </i> <a href="http://www.sintegra.gov.br/"> SINTEGRA </a>
     *
     * @param estado estado, exemplo: MG, SP, RJ, ES
     * @param ie inscrição estadual a ser validada
     */
    public InscricaoEstadual(String estado, String ie) {
        this.estado = estado.toUpperCase();
        this.ie = ie;
    }

    /**
     * Verifica se a inscrição estadual passada é válida para o estado, o qual também foi passado por parâmetro
     *
     * @return caso a inscrição estadual seja considerada válida para aquele
     * estado, retorna-se verdadeiro, senão retorna-se falso.
     */
    public boolean isIE() {
        if (estado.isEmpty()) {
            return false;
        } else if (estado.length() != 2) {
            return false;
        }

        if (estado.equals("AC")) {
            return new EstAC(ie).isIEAC();
        } else if (estado.equals("AL")) {
            return new EstAL(ie).isIEAL();
        } else if (estado.equals("AL")) {
            return new EstAL(ie).isIEAL();
        } else if (estado.equals("AP")) {
            return new EstAP(ie).isIEAP();
        } else if (estado.equals("AM")) {
            return new EstAM(ie).isIEAM();
        } else if (estado.equals("BA")) {
            return new EstBA(ie).isIEBA();
        } else if (estado.equals("CE")) {
            return new EstCE(ie).isIECE();
        } else if (estado.equals("DF")) {
            return new EstDF(ie).isIEDF();
        } else if (estado.equals("ES")) {
            return new EstES(ie).isIEES();
        } else if (estado.equals("GO")) {
            return new EstGO(ie).isIEGO();
        } else if (estado.equals("MA")) {
            return new EstMA(ie).isIEMA();
        } else if (estado.equals("MT")) {
            return new EstMT(ie).isIEMT();
        } else if (estado.equals("MS")) {
            return new EstMS(ie).isIEMS();
        } else if (estado.equals("MG")) {
            return new EstMG(ie).isIEMG();
        } else if (estado.equals("PA")) {
            return new EstPA(ie).isIEPA();
        } else if (estado.equals("PB")) {
            return new EstPB(ie).isIEPB();
        } else if (estado.equals("PR")) {
            return new EstPR(ie).isIEPR();
        } else if (estado.equals("PE")) {
            return new EstPE(ie).isIEPE();
        } else if (estado.equals("PI")) {
            return new EstPI(ie).isIEPI();
        } else if (estado.equals("RJ")) {
            return new EstRJ(ie).isIERJ();
        } else if (estado.equals("RN")) {
            return new EstRN(ie).isIERN();
        } else if (estado.equals("RS")) {
            return new EstRS(ie).isIERS();
        } else if (estado.equals("RO")) {
            return new EstRO(ie).isIERO();
        } else if (estado.equals("RR")) {
            return new EstRR(ie).isIERR();
        } else if (estado.equals("SC")) {
            return new EstSC(ie).isIESC();
        } else if (estado.equals("SP")) {
            return new EstSP(ie).isIESP();
        } else if (estado.equals("SE")) {
            return new EstSE(ie).isIESE();
        } else if (estado.equals("TO")) {
            return new EstTO(ie).isIETO();
        }

        return false;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
    //</editor-fold>
}
