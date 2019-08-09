/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_horario;

/**
 *
 * @author angelrg
 */
public class peso {

    nodo nodoSiguiente;
    double peso;
    double feromonas;

    public peso(nodo nodoSiguiente, double peso, double feromonas) {
        this.nodoSiguiente = nodoSiguiente;
        this.peso = peso;
        this.feromonas = feromonas;
    }

    public peso() {
    }

    public nodo getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoSiguiente(nodo nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getFeromonas() {
        return feromonas;
    }

    public void setFeromonas(double feromonas) {
        this.feromonas = feromonas;
    }
}
