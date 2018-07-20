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
     * Deve-se passar a sigla correspondente do estado ao qual se deseja validar
     * a inscrição estadual, seguido da inscrição estadual a ser validada.
     * <br/><br/>
     *
     * <i> Para maiores informações acesse: </i>
     * <a href="http://www.sintegra.gov.br/"> SINTEGRA </a>
     *
     * @param estado estado, exemplo: MG, SP, RJ, ES
     * @param ie inscrição estadual a ser validada
     */
    public InscricaoEstadual(String estado, String ie) {
        this.estado = estado.toUpperCase();
        this.ie = ie;
    }

    /**
     * Verifica se a inscrição estadual passada é válida para o estado, o qual
     * também foi passado por parâmetro
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

        switch (estado) {
            case "AC":
                return new EstAC(ie).isIEAC();
            case "AL":
                return new EstAL(ie).isIEAL();
            case "AP":
                return new EstAP(ie).isIEAP();
            case "AM":
                return new EstAM(ie).isIEAM();
            case "BA":
                return new EstBA(ie).isIEBA();
            case "CE":
                return new EstCE(ie).isIECE();
            case "DF":
                return new EstDF(ie).isIEDF();
            case "ES":
                return new EstES(ie).isIEES();
            case "GO":
                return new EstGO(ie).isIEGO();
            case "MA":
                return new EstMA(ie).isIEMA();
            case "MT":
                return new EstMT(ie).isIEMT();
            case "MS":
                return new EstMS(ie).isIEMS();
            case "MG":
                return new EstMG(ie).isIEMG();
            case "PA":
                return new EstPA(ie).isIEPA();
            case "PB":
                return new EstPB(ie).isIEPB();
            case "PR":
                return new EstPR(ie).isIEPR();
            case "PE":
                return new EstPE(ie).isIEPE();
            case "PI":
                return new EstPI(ie).isIEPI();
            case "RJ":
                return new EstRJ(ie).isIERJ();
            case "RN":
                return new EstRN(ie).isIERN();
            case "RS":
                return new EstRS(ie).isIERS();
            case "RO":
                return new EstRO(ie).isIERO();
            case "RR":
                return new EstRR(ie).isIERR();
            case "SC":
                return new EstSC(ie).isIESC();
            case "SP":
                return new EstSP(ie).isIESP();
            case "SE":
                return new EstSE(ie).isIESE();
            case "TO":
                return new EstTO(ie).isIETO();
            default:
                break;
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
