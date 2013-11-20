/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Stwuart
 */
public class TesteConectaNoXML {

  /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, IllegalAccessException, ClassNotFoundException, Exception {
        UsuarioOracle usuario;
        
//        UsaXML xml = new UsaXML();
//        
//        
//        
//        //apenas na primeira vez
////       UsuarioOracle iniciaUsuario = new UsuarioOracle("jdbc:oracle:thin:@192.168.0.235:1521/orcl", "futebol", "futebol");
////        xml.gravaXML(iniciaUsuario);
//        
//        
//        usuario = xml.leituraXML();     
        
        
        try(Connection dbConecta = new ConexaoOracle().getConnection()){
            System.out.println("Oracle esta OK");
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            System.out.println("Nao foi possivel Conectar!! "+ e.getMessage());
        }
    }//fim main
    
}
