/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classesDAO;

import campeonatofutebol.Estadio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import persistencia.ConexaoOracle;

/**
 *
 * @author Stwuart
 */
public class EstadioDAO {
    private Estadio estadio;
    private ArrayList<Estadio> listaEstadio;

    public EstadioDAO(Estadio estadio) {
        this.estadio = estadio;
    }
    
    public EstadioDAO(){
        this.listaEstadio = new ArrayList<>();
    }
    
    
    public void insert()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        try(Connection dbConecta = new ConexaoOracle().getConnection(); PreparedStatement insert = dbConecta.prepareStatement("insert into estadio values (?, ?)")){
            insert.setInt(1, this.estadio.getCodEstadio());
            insert.setString(2, this.estadio.getNomeEstadio());
            insert.executeQuery();
            
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            System.out.println("Nao foi possivel Conectar! \n"+ e.getMessage());
        }
        
    }
    
    public ArrayList<Estadio> select() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tupla = select.executeQuery("select * from estadio order by codigo"))
        {
            
            
            while (tupla.next()){
			Estadio est = new Estadio(tupla.getInt("codigo"), tupla.getString("nome"));
                        this.listaEstadio.add(est);
		}
            return this.listaEstadio;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            System.out.println("erro ao selecionar dados. \n" + ex.getMessage());
            return null;
        }
    }
}