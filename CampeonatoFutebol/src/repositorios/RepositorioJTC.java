/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorios;

import campeonatofutebol.JogadorTimeCampeonato;
import classesDAO.JogadorTimeCampeonatoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stwuart
 */
public class RepositorioJTC {
    private static RepositorioJTC instance;
    ArrayList<JogadorTimeCampeonato> lista;
    
    private RepositorioJTC() {
        lista = new ArrayList<>();
    }
    
    // singleton
    
    public static RepositorioJTC getInstance() {
        if (instance == null) {
            
            instance = new RepositorioJTC();
        }
        
        return instance;
    }
    public void cadastrarJTC (JogadorTimeCampeonato jtc) {
        
        //Fazer a lógica
        lista.add(jtc);
    }
    
    public ArrayList<JogadorTimeCampeonato> obterListaJTC() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
        JogadorTimeCampeonatoDAO consulta = new JogadorTimeCampeonatoDAO();
        lista = consulta.select();
        return lista;
    }
}
