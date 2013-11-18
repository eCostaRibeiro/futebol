/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import campeonatofutebol.Campeonato;
import classesDAO.CampeonatoDAO;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Renan
 */
public class RepositorioCampeonato {
    
    private static RepositorioCampeonato instance;
    ArrayList<Campeonato> listaCampeonato;
    
    private RepositorioCampeonato() {
        listaCampeonato = new ArrayList<>();
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
    
    public ArrayList<Campeonato> obterListaCampeonato() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        CampeonatoDAO consulta = new CampeonatoDAO();
        listaCampeonato = consulta.select();
        return listaCampeonato;
    }
}
