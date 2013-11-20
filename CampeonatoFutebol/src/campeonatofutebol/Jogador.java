
package campeonatofutebol;

public class Jogador {
    private Time timeJogador;
    private Integer codJogador;
    private String nomeJogador;
    

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Jogador(Time codTime, Integer codJogador, String nomeJogador) {
        this.timeJogador = codTime;
        this.codJogador = codJogador;
        this.nomeJogador = nomeJogador;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtor Genérico">
    public Jogador() {
        this.timeJogador = null;
        this.codJogador = null;
        this.nomeJogador = null;
    }
    //</editor-fold>
    

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public Integer getCodJogador() {
        return codJogador;
    }
    
    public void setCodJogador(Integer codJogador) {
        this.codJogador = codJogador;
    }
    
    public String getNomeJogador() {
        return nomeJogador;
    }
    
    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }
    
    public Time getTimeJogador() {
        return timeJogador;
    }
    
    public void setTimeJogador(Time time){
        this.timeJogador = time;
    }
    //</editor-fold>
}