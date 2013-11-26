/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classesDAO;

import campeonatofutebol.EstadioEquipe;
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
public class EstadioEquipeDAO {
    private EstadioEquipe estadioEquipe;
    private ArrayList<EstadioEquipe> listaEstadioEquipe;

    public EstadioEquipeDAO(EstadioEquipe estadioEquipe) {
        this.estadioEquipe = estadioEquipe;
    }
    
    public EstadioEquipeDAO(){
        this.listaEstadioEquipe = new ArrayList<>();
    }
    
    
    public void insert()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try(Connection dbConecta = new ConexaoOracle().getConnection(); PreparedStatement insert = dbConecta.prepareStatement("insert into estadio_equipe values (?, ?)")){
            insert.setInt(1, this.estadioEquipe.getEstadioCodigo().getCodEstadio());
            insert.setInt(2, this.estadioEquipe.getEquipeCodigo().getCodTime());
            insert.executeQuery();
            
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro EstadioEquipeDAO.Insert\n" + ex.getMessage());
        }
        
    }
    
    public ArrayList<EstadioEquipe> select() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tupla = select.executeQuery("select eq.estadio_codigo, e.nome, eq.equipe_codigo, t.nome" +
                            "  from estadio_equipe eq, estadio e, equipe t" +
                            "  where eq.estadio_codigo = e.codigo and eq.equipe_codigo = t.codigo" +
                            "  order by eq.estadio_codigo"))
        {
            while (tupla.next()){
                EstadioDAO estadioDAO = new EstadioDAO();
                TimeDAO timeDAO = new TimeDAO();
                
			EstadioEquipe estTime = new EstadioEquipe(estadioDAO.selectCodigo(tupla.getInt("estadio_codigo")), timeDAO.selectCodigo(tupla.getInt("equipe_codigo")));
                        this.listaEstadioEquipe.add(estTime);
		}
            return this.listaEstadioEquipe;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro EstadioEquipeDAO.Select\n" + ex.getMessage());
        }
    }
}
