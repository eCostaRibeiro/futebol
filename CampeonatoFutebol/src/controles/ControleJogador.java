/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import campeonatofutebol.Jogador;

/**
 *
 * @author Renan
 */
//<editor-fold defaultstate="collapsed" desc="Classe de controle Jogador">
public class ControleJogador {
    public boolean cadastrarJogador (Jogador joga){
        
        boolean result = false;
        
        if (joga != null && joga.getCodJogador()!= 0 &&
                joga.getNomeJogador().length()>0); {
        
        repositorios.RepositorioJogador.getInstance().cadastrarJogador(joga);
        
        result = true;
        
    }
                
                return result;
    }
}
//</editor-fold>
