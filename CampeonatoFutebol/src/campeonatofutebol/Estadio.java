package campeonatofutebol;

public class Estadio {
    private Integer codEstadio;
    private String nomeEstadio;

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Estadio(Integer codEstadio, String nomeEstadio) {
        this.codEstadio = codEstadio;
        this.nomeEstadio = nomeEstadio;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtor Genérico">
    public Estadio() {
        this.codEstadio = null;
        this.nomeEstadio = null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Integer getCodEstadio() {
        return codEstadio;
    }
    
    public void setCodEstadio(Integer codEstadio) {
        this.codEstadio = codEstadio;
    }
    
    public String getNomeEstadio() {
        return nomeEstadio;
    }
    
    public void setNomeEstadio(String nomeEstadio) {
        this.nomeEstadio = nomeEstadio;
    }
    //</editor-fold>
    
}
