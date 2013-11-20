/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import campeonatofutebol.Arbitro;

/**
 *
 * @author Renan
 */
//<editor-fold defaultstate="collapsed" desc="Classe de controle Arbitro">
public class ControleArbitro {
    @SuppressWarnings({"empty-statement", "null"})
    public boolean cadastrarArbitro (Arbitro arb){
        
        @SuppressWarnings("UnusedAssignment")
        boolean result = false;
        
        if (arb == null && arb.getCodArbitro()!= 0 &&
                arb.getNomeArbitro().length()>0); {
                
        repositorios.RepositorioArbitro.getInstance().cadastrarArbitro(arb);
        
        result = true;
        
    }
                
                return result;
    }
}
//</editor-fold>
