
package campeonatofutebol;

public class Rodada {
    private Integer codRodada;
    private Campeonato oCampeonato;

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Rodada(Integer codRodada, Campeonato oCampeonato) {
        this.codRodada = codRodada;
        this.oCampeonato = oCampeonato;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Integer getCodRodada() {
        return codRodada;
    }
    
    public void setCod(Integer codRodada) {
        this.codRodada = codRodada;
    }
    
    public Campeonato getoCampeonato() {
        return oCampeonato;
    }
    
    public void setoCampeonato(Campeonato oCampeonato) {
        this.oCampeonato = oCampeonato;
    }
    //</editor-fold>
        
}
