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

    public void sumarLongitudCamino(double peso) {
        LongitudRecorrido += peso;
    }

    public void agregarRecorrido(nodo nodoRecorrido) {
        camino.add(nodoRecorrido);
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
    
    public void imprimirRecorrido(){
        System.out.println("\n\n\n\n\nLongitud Camino: "+this.LongitudRecorrido);
        for (nodo road : this.camino) {
            road.imprimirDatos();
        }
    }

}
