/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_horario;

import dbManager.cursoDB;
import dbManager.docenteCursoDB;
import dbManager.pesosDB;
import dbManager.salonDB;
import excepciones.InputsVaciosException;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author angelrg
 */
public class algoritmoHormiga {
    private Connection conexion;
    private docenteCursoDB docenteCursoMDB;
    private cursoDB cursosMDB;
    private pesosDB pesoMDB;
    private salonDB salonMDB;
    private LinkedList<nodo> nodos;
    private LinkedList<curso> cursos;
    private LinkedList<salon> salones;
    private LinkedList<nodo> recorrido = new LinkedList<>();

    public algoritmoHormiga(Connection conexion) throws InputsVaciosException {
        this.conexion = conexion;
        this.docenteCursoMDB = new docenteCursoDB(this.conexion);
        this.cursosMDB = new cursoDB(this.conexion);
        this.pesoMDB = new pesosDB(this.conexion);
        this.salonMDB = new salonDB(conexion);
        
        this.salones = salonMDB.getSalones();
        this.nodos = docenteCursoMDB.getNodosDocenteCurso();
        pesoMDB.getPesos(nodos);
        this.cursos = cursosMDB.getCursos();
    }
    
    

    public LinkedList<nodo> getNodos() {
        return nodos;
    }

    public void setNodos(LinkedList<nodo> nodos) {
        this.nodos = nodos;
    }

    public LinkedList<curso> getCursos() {
        return cursos;
    }

    public void setCursos(LinkedList<curso> cursos) {
        this.cursos = cursos;
    }

    public LinkedList<salon> getSalones() {
        return salones;
    }

    public void setSalones(LinkedList<salon> salones) {
        this.salones = salones;
    }

    public LinkedList<nodo> getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(LinkedList<nodo> recorrido) {
        this.recorrido = recorrido;
    }
    
}
