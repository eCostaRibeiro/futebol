/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import campeonatofutebol.Campeonato;

/**
 *
 * @author Renan
 */
//<editor-fold defaultstate="collapsed" desc="Controle da Classe Campeonato">
public class ControleCampeonato {
    
    @SuppressWarnings({"empty-statement", "null"})
    public boolean cadastrarCampeonato (Campeonato camp) throws Exception{
        
        try {
            @SuppressWarnings("UnusedAssignment")
            boolean result = false;
            
            if (camp == null && camp.getCodCamp() != 0
                    && camp.getNomeCamp().length() > 0 && camp.getAnoCamp().length() > 0);
            {
                
                repositorios.RepositorioCampeonato.getInstance().cadastrarCampeonato(camp);
                
                result = true;                
            }
            return result;
        } catch (Exception ex) {
            throw new Exception ("Erro ControleCampeonato.CadastrarCampeonato\n" + ex.getMessage());
        }
    }
}
//</editor-fold>
