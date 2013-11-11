
package campeonatofutebol;

public class Jogador {
    private Integer codJogador;
    private String nomeJogador;

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Jogador(Integer codJogador, String nomeJogador) {
        this.codJogador = codJogador;
        this.nomeJogador = nomeJogador;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtor Genérico">
    public Jogador() {
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
    //</editor-fold>
}
