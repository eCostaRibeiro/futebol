/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import campeonatofutebol.Estadio;
import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class RepositorioEstadio {
    private static RepositorioEstadio instance;
    ArrayList<Estadio> listaEstadio;
    
    private RepositorioEstadio() {
        listaEstadio = new ArrayList<Estadio>();
    }
    
    // singleton
    
    public static RepositorioEstadio getInstance () {
        if (instance == null) {
            
            instance = new RepositorioEstadio();
        }
        
        return instance;
    }
    public void cadastrarEstadio (Estadio etd) {
        
        //Fazer a lógica
        listaEstadio.add(etd);
    }
}
