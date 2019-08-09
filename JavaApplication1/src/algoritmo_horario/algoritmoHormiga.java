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
    private LinkedList<LinkedList<nodo>> recorrido = new LinkedList<>();

    public algoritmoHormiga(Connection conexion, int semestreActual) throws InputsVaciosException {
        this.conexion = conexion;
        this.docenteCursoMDB = new docenteCursoDB(this.conexion);
        this.cursosMDB = new cursoDB(this.conexion);
        this.salonMDB = new salonDB(conexion);
        this.casillaHorarioMDB = new CasillasHorarioDB(conexion);
        this.constantes = new constants(conexion);
        this.pesoMDB = new pesosDB(this.conexion, constantes);

        this.horario = casillaHorarioMDB.getHorario(constantes.duracionPeriodo);
        this.salones = salonMDB.getSalones();
        this.nodos = docenteCursoMDB.getNodosDocenteCurso();
        this.nodosDisponibles = docenteCursoMDB.getNodosDocenteCurso();
        pesoMDB.getPesos(nodos, semestreActual);
        this.cursos = cursosMDB.getCursos();
    }

    public void crearHorario() {
        for (int i = 0; i < constantes.iteraciones; i++) {
            int inicio = enteroAleatorio(0, (nodos.size() - 1));
            nodo nodoActual = null;

            for (nodo nodoFind : nodos) {
            }

            while (!nodosDisponibles.isEmpty()) {

            }
        }

    }

    private peso probabilidad(nodo calcNodo) {
        peso nodoAux = null;
        double mejorProbabilidad = 0;
        double probabilidadGeneral = 0;

        for (peso pesoList : calcNodo.getPesos()) {
            probabilidadGeneral += (Math.pow(pesoList.getFeromonas(), constantes.alpha));
        }

        for (peso pesoAux : calcNodo.getPesos()) {
            double aux = ((Math.pow(pesoAux.getFeromonas(), constantes.alpha) * pesoAux.getPeso()) / probabilidadGeneral);
            if (aux > mejorProbabilidad) {
                nodoAux = pesoAux;
                mejorProbabilidad = aux;
            }
        }

        return nodoAux;
    }

    private int enteroAleatorio(int limiteInferior, int limiteSuperior) {
        return (int) ((Math.random() * ((limiteSuperior - limiteInferior) + 1)) + limiteInferior);
    }

    private boolean estaElNodoEnLaLista(LinkedList<nodo> listNodos, nodo nodoABuscar) {
        for (nodo listNodo : listNodos) {
            if (listNodo.getIdNodo() == nodoABuscar.getIdNodo()) {
                return true;
            }
        }
        return false;
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
