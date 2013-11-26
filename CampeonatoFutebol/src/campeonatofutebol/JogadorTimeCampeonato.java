/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package campeonatofutebol;

/**
 *
 * @author Stwuart
 */
public class JogadorTimeCampeonato {
    private Jogador jogador;
    private Time time;
    private Campeonato campeonato;

    public JogadorTimeCampeonato(Jogador jogador, Time time, Campeonato campeonato) {
        this.jogador = jogador;
        this.time = time;
        this.campeonato = campeonato;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
    
    
}
