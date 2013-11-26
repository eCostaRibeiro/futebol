package campeonatofutebol;

public class Campeonato {
    private Integer codCamp;
    private String nomeCamp;
    private String anoCamp;
    

    //<editor-fold defaultstate="expanded" desc="Construtor">
    public Campeonato(Integer codCamp, String nomeCamp, String anoCamp) {
        this.codCamp = codCamp;
        this.nomeCamp = nomeCamp;
        this.anoCamp = anoCamp;
    }
    //</editor-fold>

    //<editor-fold defaultstate="expanded" desc="Construtor Genérico">
    public Campeonato() {
        this.codCamp = null;
        this.nomeCamp = null;
        this.anoCamp = null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Integer getCodCamp() {
        return codCamp;
    }
    
    public void setCodCamp(Integer codCamp) {
        this.codCamp = codCamp;
    }
    
    public String getNomeCamp() {
        return nomeCamp;
    }
    
    public void setNomeCamp(String nomeCamp) {
        this.nomeCamp = nomeCamp;
    }
    
    public String getAnoCamp() {
        return anoCamp;
    }
    
    public void setAnoCamp(String anoCamp) {
        this.anoCamp = anoCamp;
    }
    //</editor-fold>
}