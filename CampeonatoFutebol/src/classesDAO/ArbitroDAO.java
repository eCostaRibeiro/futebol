/*
 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classesDAO;

import campeonatofutebol.Arbitro;
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
public class ArbitroDAO {
    private Arbitro arbitro;
    private ArrayList<Arbitro> listaArbitro;

    public ArbitroDAO(Arbitro arbitro) {
        this.arbitro = arbitro;
    }
    
    public ArbitroDAO(){
        this.listaArbitro = new ArrayList<>();
    }
    
    
    public void insert()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        try(Connection dbConecta = new ConexaoOracle().getConnection();
                PreparedStatement insert = dbConecta.prepareStatement("insert into arbitro values (?, ?)")){
            insert.setInt(1, this.arbitro.getCodArbitro());
            insert.setString(2, this.arbitro.getNomeArbitro());
            insert.executeQuery();
            
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            System.out.println("Nao foi possivel Conectar! \n"+ e.getMessage());
        }
        
    }
    
    public ArrayList<Arbitro> select() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tupla = select.executeQuery("select * from arbitro order by codigo"))
        {
            
            
            while (tupla.next()){
			Arbitro arb = new Arbitro(tupla.getInt("codigo"), tupla.getString("nome"));
                        this.listaArbitro.add(arb);
		}
            return this.listaArbitro;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            System.out.println("erro ao selecionar dados. \n" + ex.getMessage());
            return null;
        }
    }
}//fim da classe
