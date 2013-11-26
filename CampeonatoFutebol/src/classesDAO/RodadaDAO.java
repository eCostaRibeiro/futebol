/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classesDAO;


import campeonatofutebol.Arbitro;
import campeonatofutebol.Campeonato;
import campeonatofutebol.Estadio;
import campeonatofutebol.Partida;
import campeonatofutebol.Rodada;
import campeonatofutebol.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import persistencia.ConexaoOracle;
import repositorios.RepositorioTime;

/**
 *
 * @author Stwuart
 */
public class RodadaDAO {
    private Rodada rodada;
    private ArrayList<Rodada> lista;

//<editor-fold defaultstate="collapsed" desc="Construtores">
    public RodadaDAO(Rodada rodada) {
        this.rodada = rodada;
    }
    
    public RodadaDAO(){
        this.lista = new ArrayList<>();
    }
//</editor-fold>
    
    public void insert()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try(Connection dbConecta = new ConexaoOracle().getConnection();
                PreparedStatement insert = dbConecta.prepareStatement("insert into rodada values (?, ?)"))
        {
            insert.setInt(1, this.rodada.getoCampeonato().getCodCamp());
            insert.setInt(2, this.rodada.getCodRodada());
            insert.executeQuery();
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro RodadaDAO.insert\n " + ex.getMessage());
        }catch (Exception ex){
            throw new Exception ("Erro RodadaDAO.Insert\n"+ ex.getMessage());
        }
    }//fim insert
    
    public ArrayList<Rodada> select() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tuplaJ = select.executeQuery("select campeonato_codigo, codigo "
                        + "from rodada "
                        + "order by campeonato_codigo asc, codigo asc")
                )
        {
            CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
            while (tuplaJ.next()){
                Rodada aRodada = new Rodada(campeonatoDAO.selectCodigo(tuplaJ.getInt("campeonato_codigo")), tuplaJ.getInt("codigo"));
                this.lista.add(aRodada);
            }
            return this.lista;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro RodadaDAO.select\n " + ex.getMessage());
        }
    }// Fim select
    
    public Rodada selectCodigo(Integer codigo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement();
                ResultSet tuplaJ = select.executeQuery("select r.campeonato_codigo, r.codigo "
                        + "from rodada r, campeonato c "
                        + "where c.codigo = r.campeonato_codigo and r.codigo = " + codigo
                        + " order by c.codigo asc, r.codigo asc")
                )
        {
            CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
            tuplaJ.next();
            Rodada aRodada = new Rodada(campeonatoDAO.selectCodigo(tuplaJ.getInt("Campeonato_codigo")), tuplaJ.getInt("codigo"));
            return aRodada;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro RodadaDAO.selectCodigo\n " + ex.getMessage());
        }
    }// Fim select
    
     public void GerarRodadas(Campeonato campeonato) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        try (Connection dbConecta = new ConexaoOracle().getConnection();
                Statement select = dbConecta.createStatement())
        {
            Campeonato oCampeonato = campeonato;
            
            ArrayList<Time> listaTime = new RepositorioTime().obterListaTime();
            
            int tmLista = listaTime.size();
            int rodadasTotais = (((tmLista * (tmLista - 1)) / (tmLista / 2)));
            int numRodada = 1;
            int partida = 1;
            
            //faz a manipulação dos times e grava na partida--------------- ORDENA_TIME
            try{
                
                //<editor-fold defaultstate="collapsed" desc="TURNO">
                //TURNO
                while (numRodada <= (rodadasTotais / 2)){
                    Rodada aRodada = new Rodada(oCampeonato, numRodada);
                    RodadaDAO salva = new RodadaDAO(aRodada);
                    salva.insert();
                    try
                        {
                        for (int i = 0; i < (tmLista / 2); i++){
                            ResultSet tuplaInfo = select.executeQuery("select arbitro_estadio.codigo_estadio, arbitro_estadio.codigo_arbitro "
                                + "from arbitro_estadio, estadio_equipe "
                                + "where arbitro_estadio.codigo_estadio = estadio_equipe.estadio_codigo and estadio_equipe.equipe_codigo = " 
                                + listaTime.get(i).getCodTime());
                            tuplaInfo.next();
                            Estadio oEstadio = new EstadioDAO().selectCodigo(tuplaInfo.getInt("codigo_estadio"));
                            Arbitro oArbitro = new ArbitroDAO().selectCodigo(tuplaInfo.getInt("codigo_arbitro"));
                            
                            Partida novaPartida = new Partida(oCampeonato, aRodada, partida, oArbitro, oEstadio, listaTime.get(i),listaTime.get((tmLista-1) - i));
                            PartidaDAO salvar = new PartidaDAO(novaPartida);
                            salvar.insert();
                            
                            partida++;
                        }//final For de TURNO
                        
                        
                    }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
                        throw new Exception ("Erro RodadaDAO.GerarRodadas.tryTurno\n" + ex.getMessage());
                    }//TRY CATCH TURNO
                    
                    
                    
                    
                    
                    //<editor-fold defaultstate="collapsed" desc="ordenação e reordenação da lista de times">
                    int esq = 1;
                    int dir = (tmLista - 1);
                    
                    while (esq < dir){
                        Time temp = listaTime.get(esq);
                        listaTime.set(esq, listaTime.get(dir));
                        listaTime.set(dir, temp);
                        dir--;
                    }//fim while ordenação
//</editor-fold>
                    numRodada++;
                }//fim while TURNO
//</editor-fold>

                //<editor-fold defaultstate="collapsed" desc="RETURNO">
//RETURNO
                while (numRodada <= rodadasTotais){
                    Rodada aRodada = new Rodada(oCampeonato, numRodada);
                    RodadaDAO salva = new RodadaDAO(aRodada);
                    salva.insert();
                    try{
                        for (int i = 0; i < (tmLista / 2); i++){
                            ResultSet tuplaInfo = select.executeQuery("select arbitro_estadio.codigo_estadio, arbitro_estadio.codigo_arbitro "
                                + "from arbitro_estadio, estadio_equipe "
                                + "where arbitro_estadio.codigo_estadio = estadio_equipe.estadio_codigo and estadio_equipe.equipe_codigo = " 
                                + listaTime.get((tmLista-1) - i).getCodTime());
                            tuplaInfo.next();
                            Estadio oEstadio = new EstadioDAO().selectCodigo(tuplaInfo.getInt("codigo_estadio"));
                            Arbitro oArbitro = new ArbitroDAO().selectCodigo(tuplaInfo.getInt("codigo_arbitro"));
                            
                            Partida novaPartida = new Partida(oCampeonato, aRodada, partida, oArbitro, oEstadio, listaTime.get((tmLista-1) - i),listaTime.get(i));
                            PartidaDAO salvar = new PartidaDAO(novaPartida);
                            salvar.insert();
                            
                            partida++;
                        }// final For de Returno
                    }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
                        throw new Exception ("Erro RodadaDAO.GerarRodadas.tryReturno\n" + ex.getMessage());
                    }//TRY CATCH RETURNO
                    
                    
                    numRodada++;
                }//fim while RETURNO
                //</editor-fold>
            } //FIM TRY TURNO E RETURNO
            catch (Exception ex){
                throw new Exception("Erro RodadaDAO.GerarRodadas.Ordena_Times\n" + ex.getMessage());
            }


        } //FIM TRY DE  CONEXÃO
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            throw new Exception ("Erro RodadaDAO.SelectCodigo\n" + ex.getMessage());
        }
    }
}
