
package campeonatofutebol;

public class Time {
    private Integer codTime;
    private String nomeTime;

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Time(Integer codTime, String nomeTime) {
        this.codTime = codTime;
        this.nomeTime = nomeTime;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtor Genérico">
    public Time() {
        this.nomeTime = null;
        this.codTime = null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Integer getCodTime() {
        return codTime;
    }
    
    public void setCodTime(Integer codTime) {
        this.codTime = codTime;
    }
    
    public String getNomeTime() {
        return nomeTime;
    }
    
    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }
    //</editor-fold>

}
