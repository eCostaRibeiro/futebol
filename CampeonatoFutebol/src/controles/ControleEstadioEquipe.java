/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controles;

import campeonatofutebol.EstadioEquipe;

/**
 *
 * @author Stwuart
 */


//<editor-fold defaultstate="collapsed" desc="Classe de controle Estadio">
public class ControleEstadioEquipe {
    @SuppressWarnings({"empty-statement", "null"})
    public boolean cadastrarEstadioEquipe (EstadioEquipe estTime){
        
        @SuppressWarnings("UnusedAssignment")
        boolean result = false;
        
        if (estTime == null && estTime.getEstadioCodigo().getCodEstadio() != 0 &&
                estTime.getEquipeCodigo().getCodTime() != 0); {
        
        repositorios.RepositorioEstadioEquipe.getInstance().cadastrarEstadioEquipe(estTime);
        
        result = true;
        
    }
                
                return result;
    }
    //</editor-fold>
}
