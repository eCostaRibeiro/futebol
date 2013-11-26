/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classesDAO;

import campeonatofutebol.Campeonato;
import campeonatofutebol.Jogador;
import campeonatofutebol.JogadorTimeCampeonato;
import campeonatofutebol.Time;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import persistencia.ConexaoOracle;

/**
 *
 * @author Stwuart
 */
public class JogadorTimeCampeonatoDAO {
    private Jogador jogador;
    private Time time;
    private Campeonato campeonato;
    private ArrayList<JogadorTimeCampeonato> lista;

    public JogadorTimeCampeonatoDAO(Jogador jogador, Time time, Campeonato campeonato) {
        this.jogador = jogador;
        this.time = time;
        this.campeonato = campeonato;
    }

    public JogadorTimeCampeonatoDAO() {
        this.lista = new ArrayList<>();
    }
    
    public ArrayList<JogadorTimeCampeonato> select() throws Exception{
        
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tupla = select.executeQuery("select jogador_codigo, equipe_codigo, campeonato_codigo "
                        + "from jogador_time_campeonato "
                        + "order by campeonato_codigo asc, equipe_codigo asc, jogador_codigo asc"))
        {
            while (tupla.next()){
                JogadorDAO jogadorDAO = new JogadorDAO();
                TimeDAO timeDAO = new TimeDAO();
                CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
                
                
                JogadorTimeCampeonato jtc = new JogadorTimeCampeonato(
                        jogadorDAO.selectCodigo(tupla.getInt("jogador_codigo")),
                        timeDAO.selectCodigo(tupla.getInt("equipe_codigo")),
                        campeonatoDAO.selectCodigo(tupla.getInt("campeonato_codigo")));
                this.lista.add(jtc);
                
            }
                
            return this.lista;
        } catch (Exception ex) {
            throw new Exception ("Erro JogadorTimeCampeonatoDAO.select\n" + ex.getMessage());
        }
        
    }
    
    
}
