/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import campeonatofutebol.Campeonato;
import java.util.ArrayList;


/**
 *
 * @author Renan
 */
public class RepositorioCampeonato {
    
    private static RepositorioCampeonato instance;
    ArrayList<Campeonato> listaCampeonato;
    
    private RepositorioCampeonato() {
        listaCampeonato = new ArrayList<Campeonato>();
    }
    
    // singleton
    
    public static RepositorioCampeonato getInstance () {
        if (instance == null) {
            
            instance = new RepositorioCampeonato();
        }
        
        return instance;
    }
    public void cadastrarCampeonato (Campeonato camp) {
        
        //Fazer a lógica
        listaCampeonato.add(camp);
    }
    
    public ArrayList<Campeonato> obterListaCampeonato() {
        
        return listaCampeonato;
    }
}
