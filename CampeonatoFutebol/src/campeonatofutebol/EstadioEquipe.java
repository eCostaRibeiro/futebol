/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package campeonatofutebol;

/**
 *
 * @author Stwuart
 */
public class EstadioEquipe {
    private Estadio estadioCodigo;
    private Time equipeCodigo;

    public EstadioEquipe(Estadio estadioCodigo, Time equipeCodigo) {
        this.estadioCodigo = estadioCodigo;
        this.equipeCodigo = equipeCodigo;
    }

    public EstadioEquipe(){
        this.equipeCodigo = null;
        this.estadioCodigo = null;
    }
    
    public Estadio getEstadioCodigo() {
        return estadioCodigo;
    }

    public void setEstadioCodigo(Estadio estadioCodigo) {
        this.estadioCodigo = estadioCodigo;
    }

    public Time getEquipeCodigo() {
        return equipeCodigo;
    }

    public void setEquipeCodigo(Time equipeCodigo) {
        this.equipeCodigo = equipeCodigo;
    }
    
    
}
