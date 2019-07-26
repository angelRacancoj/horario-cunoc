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
public class salon {

    int id;
    String nombre;
    int capacidad;

    public salon(int id, String nombre, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }
    
    public salon(String id, String nombre, String capacidad) {
        this.id = Integer.getInteger(id);
        this.nombre = nombre;
        this.capacidad = Integer.getInteger(capacidad);
    }

    public salon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
