/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classesDAO;

import campeonatofutebol.Jogador;
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
public class JogadorDAO {
    private Jogador jogador;
    private ArrayList<Jogador> listaJogador;

    public JogadorDAO(Jogador jogador) {
        this.jogador = jogador;
    }
    
    public JogadorDAO(){
        this.listaJogador = new ArrayList<>();
    }
    
    
    public void insert()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try(Connection dbConecta = new ConexaoOracle().getConnection();
                PreparedStatement insert = dbConecta.prepareStatement("insert into estadio values (?, ?, ?)"))
        {
            insert.setInt(1, this.jogador.getTimeJogador().getCodTime());
            insert.setInt(2, this.jogador.getCodJogador());
            insert.setString(3, this.jogador.getNomeJogador());
            insert.executeQuery();
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro ao selecionar os dados\n " + ex.getMessage());
        }
    }//fim insert
    
    
    //parei aqui!!!!!!!!!!!!!!!;....................................................................................................................................................................................................
    public ArrayList<Jogador> select() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tuplaJ = select.executeQuery("select j.equipe_codigo, j.codigo, j.nome "
                        + "from jogador j, equipe t "
                        + "where j.equipe_codigo = t.codigo "
                        + "order by t.codigo asc, j.codigo asc")
                )
        {
            //Time timeJogador = new Time();
            TimeDAO timeDAO = new TimeDAO();
            while (tuplaJ.next()){
                Jogador jog = new Jogador(timeDAO.selectCodigo(tuplaJ.getInt("equipe_codigo")), tuplaJ.getInt("codigo"), tuplaJ.getString("nome"));
                this.listaJogador.add(jog);
            }
            return this.listaJogador;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro ao selecionar os dados\n " + ex.getMessage());
        }
    }    
}