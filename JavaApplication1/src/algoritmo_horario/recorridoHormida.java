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
public class recorridoHormida {

    LinkedList<nodo> camino = new LinkedList<>();
    double LongitudRecorrido = 0;

    public recorridoHormida() {
    }

    public void sumarLongitudCamino(int peso) {
        LongitudRecorrido += peso;
    }

    public LinkedList<nodo> getCamino() {
        return camino;
    }

    public void setCamino(LinkedList<nodo> camino) {
        this.camino = camino;
    }

    public double getLongitudRecorrido() {
        return LongitudRecorrido;
    }

    public void setLongitudRecorrido(double LongitudRecorrido) {
        this.LongitudRecorrido = LongitudRecorrido;
    }

}
