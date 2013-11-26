/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorios;

import campeonatofutebol.EstadioEquipe;
import classesDAO.EstadioEquipeDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stwuart
 */
public class RepositorioEstadioEquipe {
    private static RepositorioEstadioEquipe instance;
    ArrayList<EstadioEquipe> lista;
    
    private RepositorioEstadioEquipe() {
        lista = new ArrayList<>();
    }
    
    // singleton
    
    public static RepositorioEstadioEquipe getInstance() {
        if (instance == null) {
            
            instance = new RepositorioEstadioEquipe();
        }
        
        return instance;
    }
    public void cadastrarEstadioEquipe (EstadioEquipe etdTime) {
        
        //Fazer a lógica
        lista.add(etdTime);
    }
    
    public ArrayList<EstadioEquipe> obterListaEstadioEquipe() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
        EstadioEquipeDAO consulta = new EstadioEquipeDAO();
        lista = consulta.select();
        return lista;
    }
}
