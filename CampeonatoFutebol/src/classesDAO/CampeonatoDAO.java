/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classesDAO;

import campeonatofutebol.Campeonato;
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
public class CampeonatoDAO {
    private Campeonato campeonato;
    private ArrayList<Campeonato> listaCampeonato;

    public CampeonatoDAO(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
    
    public CampeonatoDAO(){
        this.listaCampeonato = new ArrayList<>();
    }
    
    
    public void insert()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try(Connection dbConecta = new ConexaoOracle().getConnection(); 
                PreparedStatement insert = dbConecta.prepareStatement("insert into campeonato values (?, ?, ?)"))
        {
            insert.setInt(1, this.campeonato.getCodCamp());
            insert.setString(2, this.campeonato.getNomeCamp());
            insert.setString(3, this.campeonato.getAnoCamp());
            insert.executeQuery();
            
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro CampeonatoDAO.Insert" + ex.getMessage());
        }catch (Exception ex){
            throw new Exception ("Erro CampeonatoDAO.Insert\n"+ ex.getMessage());
        }
        
    }
    
    public ArrayList<Campeonato> select() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tupla = select.executeQuery("select * from campeonato order by codigo"))
        {           
            while (tupla.next()){
                Campeonato camp = new Campeonato(tupla.getInt("codigo"), tupla.getString("nome"), tupla.getString("ano"));
                this.listaCampeonato.add(camp);
            }
            return this.listaCampeonato;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro CampeonatoDAO.select" + ex.getMessage());
        }
    }
}
