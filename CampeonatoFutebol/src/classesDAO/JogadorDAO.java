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
    private ArrayList<Jogador> lista;

    public JogadorDAO(Jogador jogador) {
        this.jogador = jogador;
    }
    
    public JogadorDAO(){
        this.lista = new ArrayList<>();
    }

    public void insert()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try(Connection dbConecta = new ConexaoOracle().getConnection();
                PreparedStatement insert = dbConecta.prepareStatement("insert into jogador values (?, ?, ?)"))
        {
            insert.setInt(1, this.jogador.getTimeJogador().getCodTime());
            insert.setInt(2, this.jogador.getCodJogador());
            insert.setString(3, this.jogador.getNomeJogador());
            insert.executeQuery();
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro JogadorDAO.insert\n " + ex.getMessage());
        }catch (Exception ex){
            throw new Exception ("Erro JogadorDAO.Insert\n"+ ex.getMessage());
        }
    }//fim insert
    
    
    //select padrão
    public ArrayList<Jogador> select() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tuplaJ = select.executeQuery("select j.equipe_codigo, j.codigo, j.nome "
                        + "from jogador j, equipe t "
                        + "where j.equipe_codigo = t.codigo "
                        + "order by t.codigo asc, j.codigo asc")
                )
        {
            TimeDAO timeDAO = new TimeDAO();
            while (tuplaJ.next()){
                Jogador jog = new Jogador(timeDAO.selectCodigo(tuplaJ.getInt("equipe_codigo")), tuplaJ.getInt("codigo"), tuplaJ.getString("nome"));
                this.lista.add(jog);
            }
            return this.lista;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro Jogador.select\n " + ex.getMessage());
        }
    }// Fim select
    
    public Jogador selectCodigo(Integer codigo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tupla = select.executeQuery("select equipe_codigo, codigo, nome "
                        + "from jogador "
                        + "where codigo = " + codigo
                        + "order by equipe_codigo asc, codigo asc")
                )
        {           
            tupla.next();
            TimeDAO timeDAO = new TimeDAO();
            
            Jogador joga = new Jogador(timeDAO.selectCodigo(tupla.getInt("equipe_codigo")),
                    tupla.getInt("codigo"), tupla.getString("nome"));
                
                    return joga;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro JogadorDAO.SelectCodigo\n" + ex.getMessage());
        }
    }//FIM selectCodigo
}