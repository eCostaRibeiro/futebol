/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classesDAO;

import campeonatofutebol.Time;
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
public class TimeDAO {
    private Time time;
    private ArrayList<Time> lista;

    public TimeDAO(Time time) {
        this.time = time;
    }
    
    public TimeDAO(){
        this.lista = new ArrayList<>();
    }
    
    
    public void insert()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try(Connection dbConecta = new ConexaoOracle().getConnection(); PreparedStatement insert = dbConecta.prepareStatement("insert into equipe values (?, ?)")){
            insert.setInt(1, this.time.getCodTime());
            insert.setString(2, this.time.getNomeTime());
            insert.executeQuery();
            
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro TimeDAO.Insert\n" + ex.getMessage());
        }
        
    }
    
    public ArrayList<Time> select() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tupla = select.executeQuery("select * from equipe order by codigo"))
        {           
            while (tupla.next()){
                Time tme = new Time(tupla.getInt("codigo"), tupla.getString("nome"));
                this.lista.add(tme);
            }
            return this.lista;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro TimeDAO.select\n" + ex.getMessage());
        }
    }
    
    public Time selectCodigo(Integer codigo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tupla = select.executeQuery("select codigo, nome from equipe where codigo = " + codigo))
        {           
            tupla.next();
            Time tme = new Time(tupla.getInt("codigo"), tupla.getString("nome"));
                
                    return tme;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro TimeDAO.SelectCodigo\n" + ex.getMessage());
        }
    }
}