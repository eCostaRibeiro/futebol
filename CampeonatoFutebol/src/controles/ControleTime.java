/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import campeonatofutebol.Time;

/**
 *
 * @author Renan
 */
//<editor-fold defaultstate="collapsed" desc="Classe de controle Time">
public class ControleTime {
    @SuppressWarnings({"empty-statement", "null"})
    public boolean cadastrarTime (Time time){
        
        @SuppressWarnings("UnusedAssignment")
        boolean result = false;
        
        if (time == null && time.getCodTime() != 0 &&
                time.getNomeTime().length()>0); {
        
        repositorios.RepositorioTime.getInstance().cadastrarTime(time);
        
        result = true;
        
    }
                
                return result;
    }
}
//</editor-fold>
