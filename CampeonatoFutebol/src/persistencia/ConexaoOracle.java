
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
    Connection con;

    public Connection getConnection(UsuarioOracle usuarioVar) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	this.conected = false;
	this.usuario = usuarioVar;
                
        try{
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(this.usuario.getUrl());
            ods.setPassword(this.usuario.getSenha());
            ods.setUser(this.usuario.getUsuario());
            this.con = ods.getConnection();
            this.con.setAutoCommit(true);
            this.conected = true;

            return this.con;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel Conectar!! \n"+ e.getMessage());
            return null;
        }
	
	
}

    public void disconecta() throws SQLException{
        try{
            if(checkConection()){
                this.conected = false;                
                this.con.close();
            }
        }catch(SQLException e) {
            System.out.println("Erro ao desconectar!! \n"+ e.getMessage());
        }
    }

    public boolean checkConection(){
            return this.conected;
    }
}
