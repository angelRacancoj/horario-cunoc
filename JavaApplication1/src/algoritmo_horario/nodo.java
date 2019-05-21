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
public class nodo {
    int id;
    int idCurso;
    int idDocente;
    LinkedList<peso> pesos;

    public nodo(int id, int idCurso, int idDocente, LinkedList<peso> pesos) {
        this.id = id;
        this.idCurso = idCurso;
        this.idDocente = idDocente;
        this.pesos = pesos;
    }

    public nodo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public LinkedList<peso> getPesos() {
        return pesos;
    }

    public void setPesos(LinkedList<peso> pesos) {
        this.pesos = pesos;
    }
}
