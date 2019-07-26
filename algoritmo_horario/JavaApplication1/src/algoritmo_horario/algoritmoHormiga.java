/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_horario;

import dbManager.CasillasHorarioDB;
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
    private CasillasHorarioDB casillaHorarioMDB;
    private constants constantes;

    private LinkedList<nodo> nodos;
    private LinkedList<nodo> nodosDisponibles;
    private LinkedList<curso> cursos;
    private LinkedList<salon> salones;
    private LinkedList<LinkedList<LinkedList<casillaHorario>>> horario;
    private LinkedList<nodo> recorrido = new LinkedList<>();

    public algoritmoHormiga(Connection conexion) throws InputsVaciosException {
        this.conexion = conexion;
        this.docenteCursoMDB = new docenteCursoDB(this.conexion);
        this.cursosMDB = new cursoDB(this.conexion);
        this.pesoMDB = new pesosDB(this.conexion);
        this.salonMDB = new salonDB(conexion);
        this.casillaHorarioMDB = new CasillasHorarioDB(conexion);
        this.constantes = new constants(conexion);

//        this.horario = casillaHorarioMDB.getHorario(constantes.duracionPeriodo);
        this.salones = salonMDB.getSalones();
        this.nodos = docenteCursoMDB.getNodosDocenteCurso();
        this.nodosDisponibles = docenteCursoMDB.getNodosDocenteCurso();
        pesoMDB.getPesos(nodos);
        this.cursos = cursosMDB.getCursos();
    }

    public void crearHorario() {
        int inicio = enteroAleatorio(0, nodos.size());
        
    }
    
//    private peso probabilidad(nodo calcNodo){
//        peso pesoAux;
//        double probabilidad = 0;
//        for (peso peso : calcNodo.getPesos()) {
//            for (peso pesoSum : calcNodo.getPesos()) {
//            }
//        }
//    }

    private int enteroAleatorio(int limiteInferior, int limiteSuperior) {
        return (int) ((Math.random() * ((limiteSuperior - limiteInferior) + 1)) + limiteInferior);
    }

    public LinkedList<nodo> getNodos() {
        return nodos;
    }

    public LinkedList<curso> getCursos() {
        return cursos;
    }

    public LinkedList<salon> getSalones() {
        return salones;
    }

    public LinkedList<LinkedList<LinkedList<casillaHorario>>> getHorario() {
        return horario;
    }

    public LinkedList<nodo> getRecorrido() {
        return recorrido;
    }
}
