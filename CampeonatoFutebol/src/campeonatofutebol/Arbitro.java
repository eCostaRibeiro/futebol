package campeonatofutebol;

public class Arbitro {
    private Integer codArbitro;
    private String nomeArbitro;

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Arbitro(Integer codArbitro, String nomeArbitro) {
        this.codArbitro = codArbitro;
        this.nomeArbitro = nomeArbitro;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtor Genérico">
    public Arbitro() {
        this.codArbitro = null;
        this.nomeArbitro = null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Integer getCodArbitro() {
        return codArbitro;
    }
    
    public void setCodArbitro(Integer codArbitro) {
        this.codArbitro = codArbitro;
    }
    
    public String getNomeArbitro() {
        return nomeArbitro;
    }
    
    public void setNomeArbitro(String nomeArbitro) {
        this.nomeArbitro = nomeArbitro;
    }
    //</editor-fold>
  
}
