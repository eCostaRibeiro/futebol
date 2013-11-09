/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import campeonatofutebol.Time;
import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class RepositorioTime {
    private static RepositorioTime instance;
    ArrayList<Time> listaTime;
    
    private RepositorioTime() {
        listaTime = new ArrayList<Time>();
    }
    
    // singleton
    
    public static RepositorioTime getInstance () {
        if (instance == null) {
            
            instance = new RepositorioTime();
        }
        
        return instance;
    }
    public void cadastrarTime (Time time) {
        
        //Fazer a lógica
        listaTime.add(time);
    }
}
