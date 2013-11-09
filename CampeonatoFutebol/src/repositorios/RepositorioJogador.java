/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import campeonatofutebol.Jogador;
import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class RepositorioJogador {
    private static RepositorioJogador instance;
    ArrayList<Jogador> listaJogador;
    
    private RepositorioJogador() {
        listaJogador = new ArrayList<Jogador>();
    }
    
    // singleton
    
    public static RepositorioJogador getInstance () {
        if (instance == null) {
            
            instance = new RepositorioJogador();
        }
        
        return instance;
    }
    public void cadastrarJogador (Jogador joga) {
        
        //Fazer a lógica
        listaJogador.add(joga);
    }
}
