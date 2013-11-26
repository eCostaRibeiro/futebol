
package campeonatofutebol;

import java.util.ArrayList;

public class Rodada {
    private Integer codRodada;
    private Campeonato oCampeonato;
    private ArrayList<Partida> partidas;

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Rodada(Campeonato oCampeonato, Integer codRodada) {
        this.oCampeonato = oCampeonato;
        this.codRodada = codRodada;
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
    public void setPartidas(ArrayList<Partida> lista){
        this.partidas = lista;
    }
    
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }
    
    //</editor-fold> 
}
