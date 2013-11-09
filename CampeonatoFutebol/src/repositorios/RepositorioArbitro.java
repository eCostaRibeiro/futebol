/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import campeonatofutebol.Arbitro;
import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class RepositorioArbitro {
    
    private static RepositorioArbitro instance;
    ArrayList<Arbitro> listaArbitro;
    
    private RepositorioArbitro() {
        listaArbitro = new ArrayList<Arbitro>();
    }
    
    // singleton
    
    public static RepositorioArbitro getInstance () {
        if (instance == null) {
            
            instance = new RepositorioArbitro();
        }
        
        return instance;
    }
    public void cadastrarArbitro (Arbitro arb) {
        
        //Fazer a lógica
        listaArbitro.add(arb);
    }
}
