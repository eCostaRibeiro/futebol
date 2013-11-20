/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;



/**
 *
 * @author Stwuart
 */
public class UsaXML {
    private final String arquivoXML = "usuario.xml";
    private UsuarioOracle usuario;
    
    
    public void gravaXML(UsuarioOracle usuario) throws Exception{
        XStream xstream = new XStream(new StaxDriver());
        
        try (PrintStream out = new PrintStream(arquivoXML)) {
            //converte o objeto em XML
            xstream.alias("usuarioOracle", UsuarioOracle.class);
            String xml = xstream.toXML(usuario);
            
            //grava as informações no arquivo
            out.print(xml);
            imprime("Arquivo gravado com sucesso!");
            
        } catch (FileNotFoundException ex) {
            throw new Exception ("Erro ConexaoOracle.getConnection\n"+ ex.getMessage());
        }
    }//fim GravaXML
    
    public UsuarioOracle leituraXML() throws Exception{
        try (BufferedReader leitura = new BufferedReader(new FileReader(arquivoXML))) {
            XStream xstream = new XStream(new StaxDriver());
            xstream.alias("usuarioOracle", UsuarioOracle.class);
            this.usuario = (UsuarioOracle)xstream.fromXML(leitura);
            return this.usuario;
            
        }catch (Exception ex){
            throw new Exception ("Erro ConexaoOracle.getConnection\n"+ ex.getMessage());
        }
        
    }//fim leituraXML
    
    
    private void imprime(String msg){
        System.out.println(msg);
    }
}
