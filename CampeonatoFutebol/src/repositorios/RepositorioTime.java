/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import campeonatofutebol.Time;
import classesDAO.TimeDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class RepositorioTime {
    private static RepositorioTime instance;
    ArrayList<Time> listaTime;
    
    private RepositorioTime() {
        listaTime = new ArrayList<>();
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
    
    public ArrayList<Time> obterListaTime() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        TimeDAO consulta = new TimeDAO();
        listaTime = consulta.select();
        return listaTime;
    }
}
