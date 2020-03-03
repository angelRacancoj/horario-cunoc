/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_horario;

import java.util.LinkedList;

/**
 *
 * @author angelrg
 */
public class horario {
    LinkedList<LinkedList<casillaHorario>> casillas = new LinkedList<>();
    int version;

    public horario(int version) {
        this.version = version;
    }

    public horario() {
    }

    public LinkedList<LinkedList<casillaHorario>> getCasillas() {
        return casillas;
    }

    public void setCasillas(LinkedList<LinkedList<casillaHorario>> casillas) {
        this.casillas = casillas;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    
}
