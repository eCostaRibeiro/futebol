package campeonatofutebol;

public class Campeonato {
    private Integer codCamp;
    private Integer anoCamp;
    private String nomeCamp;

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Campeonato(Integer codCamp, Integer anoCamp, String nomeCamp) {
        this.codCamp = codCamp;
        this.anoCamp = anoCamp;
        this.nomeCamp = nomeCamp;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtor Genérico">
    public Campeonato() {
        this.codCamp = null;
        this.anoCamp = null;
        this.nomeCamp = null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Integer getAnoCamp() {
        return anoCamp;
    }
    
    public void setAnoCamp(Integer anoCamp) {
        this.anoCamp = anoCamp;
    }
    
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
    //</editor-fold>
}