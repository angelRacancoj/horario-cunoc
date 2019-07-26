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

    int idNodoSig;
    int idNodoActual;
    double peso;
    double feromonas;
    
    public peso(int idNodoSig, int idNodoActual, double peso, double feromonas) {
        this.idNodoSig = idNodoSig;
        this.idNodoActual = idNodoActual;
        this.peso = peso;
        this.feromonas = feromonas;
    }
    
    public peso(String idNodoSig, String idNodoActual, String peso, double feromonas) {
        this.idNodoSig = Integer.getInteger(idNodoSig);
        this.idNodoActual = Integer.getInteger(idNodoActual);
        this.peso = Integer.getInteger(peso);
        this.feromonas = feromonas;
    }
    
    public peso() {
    }
    
    public int getIdNodoSig() {
        return idNodoSig;
    }
    
    public void setIdNodoSig(int idNodoSig) {
        this.idNodoSig = idNodoSig;
    }
    
    public int getIdNodoActual() {
        return idNodoActual;
    }
    
    public void setIdNodoActual(int idNodoActual) {
        this.idNodoActual = idNodoActual;
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
