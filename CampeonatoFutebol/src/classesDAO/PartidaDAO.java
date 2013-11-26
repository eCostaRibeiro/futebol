/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classesDAO;

import campeonatofutebol.Partida;
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
public class PartidaDAO {
    private Partida partida;
    private ArrayList<Partida> lista;
    
    
//<editor-fold defaultstate="collapsed" desc="Contrutores">
    public PartidaDAO(Partida partida){
        this.partida = partida;
    }
    
    public PartidaDAO(){
        this.lista = new ArrayList<>();
    }
//</editor-fold>

    public void insert()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try(Connection dbConecta = new ConexaoOracle().getConnection();
                PreparedStatement insert = dbConecta.prepareStatement("insert into partida values (?, ?, ?, ?, ?, ?, ?)"))
        {
            insert.setInt(1, this.partida.getoCampeonato().getCodCamp());
            insert.setInt(2, this.partida.getaRodada().getCodRodada());
            insert.setInt(3, this.partida.getCodPartida());
            insert.setInt(4, this.partida.getoArbitro().getCodArbitro());
            insert.setInt(5, this.partida.getoEstadio().getCodEstadio());
            insert.setInt(6, this.partida.getTime1().getCodTime());
            insert.setInt(7, this.partida.getTime2().getCodTime());
            
            insert.executeQuery();
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro PartidaDAO.insert\n " + ex.getMessage());
        }catch (Exception ex){
            throw new Exception ("Erro PartidaDAO.Insert\n"+ ex.getMessage());
        }
    }//fim insert
    
    public ArrayList<Partida> select() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tupla = select.executeQuery("select * "
                        + "from partida "
                        + "order by rodada_campeonato_codigo asc, rodada_codigo asc, codigo asc, arbitro_codigo asc, estadio_codigo asc ")
                )
        {
            CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
            RodadaDAO rodadaDAO = new RodadaDAO();
            ArbitroDAO arbitroDAO = new ArbitroDAO();
            EstadioDAO estadioDAO = new EstadioDAO();
            TimeDAO time1DAO = new TimeDAO();
            TimeDAO time2DAO = new TimeDAO();
            while (tupla.next()){
                Partida jogo = new Partida(
                        campeonatoDAO.selectCodigo(tupla.getInt("rodada_campeonato_codigo")),
                        rodadaDAO.selectCodigo(tupla.getInt("rodada_codigo")),
                        tupla.getInt("codigo"),
                        arbitroDAO.selectCodigo(tupla.getInt("arbitro_codigo")),
                        estadioDAO.selectCodigo(tupla.getInt("estadio_codigo")),
                        time1DAO.selectCodigo(tupla.getInt("equipe_codigo")),
                        time2DAO.selectCodigo(tupla.getInt("equipe_codigo1")));
                this.lista.add(jogo);
            }
            return this.lista;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro PartidaDAO.select\n " + ex.getMessage());
        }
    }
    
}