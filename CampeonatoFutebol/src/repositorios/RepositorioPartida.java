/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorios;

import campeonatofutebol.Partida;
import classesDAO.PartidaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stwuart
 */
public class RepositorioPartida {
    private static RepositorioPartida instance;
    ArrayList<Partida> lista;
    
    private RepositorioPartida() {
        lista = new ArrayList<>();
    }
    
    public static RepositorioPartida getInstance () {
        if (instance == null) {
            
            instance = new RepositorioPartida();
        }
        
        return instance;
    }
    
    public void cadastrarPartida (Partida jogo) {
        //Fazer a lógica
        lista.add(jogo);
    }
    
    public ArrayList<Partida> obterListaPartida() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
        PartidaDAO consulta = new PartidaDAO();
        lista = consulta.select();
        return lista;
    }
}
