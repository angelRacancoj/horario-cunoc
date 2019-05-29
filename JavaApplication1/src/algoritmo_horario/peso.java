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

    int idNodoA;
    int idNodoB;
    double peso;
    double feromonas;
    
    public peso(int idNodoA, int idNodoB, double peso, double feromonas) {
        this.idNodoA = idNodoA;
        this.idNodoB = idNodoB;
        this.peso = peso;
        this.feromonas = feromonas;
    }
    
    public peso(String idNodoA, String idNodoB, String peso, double feromonas) {
        this.idNodoA = Integer.getInteger(idNodoA);
        this.idNodoB = Integer.getInteger(idNodoB);
        this.peso = Integer.getInteger(peso);
        this.feromonas = feromonas;
    }
    
    public peso() {
    }
    
    public int getIdNodoA() {
        return idNodoA;
    }
    
    public void setIdNodoA(int idNodoA) {
        this.idNodoA = idNodoA;
    }
    
    public int getIdNodoB() {
        return idNodoB;
    }
    
    public void setIdNodoB(int idNodoB) {
        this.idNodoB = idNodoB;
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
