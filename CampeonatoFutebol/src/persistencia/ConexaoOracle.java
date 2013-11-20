
package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;


/**
 *
 * @author Stwuart
 */

public class ConexaoOracle {
    private boolean conected;
    private UsuarioOracle usuario;
    private UsaXML xml;
    Connection con;

    public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
	this.xml = new UsaXML();
        this.conected = false;
	this.usuario = this.xml.leituraXML();
                
        try{
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(this.usuario.getUrl());
            ods.setPassword(this.usuario.getSenha());
            ods.setUser(this.usuario.getUsuario());
            this.con = ods.getConnection();
            this.con.setAutoCommit(true);
            this.conected = true;

            return this.con;
        } catch (SQLException ex) {
            throw new Exception ("Erro ConexaoOracle.getConnection\n"+ ex.getMessage());
        }
	
	
}

    public void disconecta() throws SQLException, Exception{
        try{
            if(checkConection()){
                this.conected = false;                
                this.con.close();
            }
        }catch(SQLException ex) {
            throw new Exception ("Erro ConexaoOracle.disconecta\n"+ ex.getMessage());
        }
    }

    public boolean checkConection(){
            return this.conected;
    }
}
