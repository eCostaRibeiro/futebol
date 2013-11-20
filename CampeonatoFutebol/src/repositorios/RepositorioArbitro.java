/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import campeonatofutebol.Arbitro;
import classesDAO.ArbitroDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class RepositorioArbitro {
    
    private static RepositorioArbitro instance;
    ArrayList<Arbitro> listaArbitro;
    
    public RepositorioArbitro() {
        listaArbitro = new ArrayList<>();
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
    
    public ArrayList<Arbitro> obterListaArbitro() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
        ArbitroDAO consulta = new ArbitroDAO();
        listaArbitro = consulta.select();
        return listaArbitro;
    }
}
