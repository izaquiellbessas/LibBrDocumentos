/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.juridico.inscricao.estadual;

/**
 *
 * @author izaquiellopesdebessas
 */
public class InscricaoEstadual {

    private String estado;
    private String ie;

    /**
     * Construtor padrão da classe
     * 
     *
     * Deve-se passar a sigla correspondente do estado ao qual se deseja validar
     * a inscrição estadual, seguido da inscrição estadual a ser validada.
     * 
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
                return new IEAC(ie).isIEAC();
            case "AL":
                return new IEAL(ie).isIEAL();
            case "AP":
                return new IEAP(ie).isIEAP();
            case "AM":
                return new IEAM(ie).isIEAM();
            case "BA":
                return new IEBA(ie).isIEBA();
            case "CE":
                return new IECE(ie).isIECE();
            case "DF":
                return new IEDF(ie).isIEDF();
            case "ES":
                return new IEES(ie).isIEES();
            case "GO":
                return new IEGO(ie).isIEGO();
            case "MA":
                return new IEMA(ie).isIEMA();
            case "MT":
                return new IEMT(ie).isIEMT();
            case "MS":
                return new IEMS(ie).isIEMS();
            case "MG":
                return new IEMG(ie).isIEMG();
            case "PA":
                return new IEPA(ie).isIEPA();
            case "PB":
                return new IEPB(ie).isIEPB();
            case "PR":
                return new IEPR(ie).isIEPR();
            case "PE":
                return new IEPE(ie).isIEPE();
            case "PI":
                return new IEPI(ie).isIEPI();
            case "RJ":
                return new IERJ(ie).isIERJ();
            case "RN":
                return new IERN(ie).isIERN();
            case "RS":
                return new IERS(ie).isIERS();
            case "RO":
                return new IERO(ie).isIERO();
            case "RR":
                return new IERR(ie).isIERR();
            case "SC":
                return new IESC(ie).isIESC();
            case "SP":
                return new IESP(ie).isIESP();
            case "SE":
                return new IESE(ie).isIESE();
            case "TO":
                return new IETO(ie).isIETO();
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
