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

    private int semestreActual;
    private Connection conexion;
    private docenteCursoDB docenteCursoMDB;
    private cursoDB cursosMDB;
    private pesosDB pesoMDB;
    private salonDB salonMDB;
    private CasillasHorarioDB casillaHorarioMDB;
    private constants constantes;

    private LinkedList<nodo> nodos;
    private LinkedList<nodo> nodosDisponibles = new LinkedList<>();
    private LinkedList<curso> cursos;
    private LinkedList<salon> salones;
    private LinkedList<LinkedList<LinkedList<casillaHorario>>> horario;
    LinkedList<recorridoHormida> recorridoCortos = new LinkedList<>();

    public algoritmoHormiga(Connection conexion, int semestreActual) throws InputsVaciosException {
        this.semestreActual = semestreActual;
        this.conexion = conexion;
        this.docenteCursoMDB = new docenteCursoDB(this.conexion);
        this.cursosMDB = new cursoDB(this.conexion);
        this.salonMDB = new salonDB(conexion);
        this.casillaHorarioMDB = new CasillasHorarioDB(conexion);
        this.constantes = new constants(conexion);
        this.pesoMDB = new pesosDB(this.conexion, constantes);

        this.horario = casillaHorarioMDB.getHorario(constantes.duracionPeriodo);
        this.salones = salonMDB.getSalones();
        this.cursos = cursosMDB.getCursos();

        nodos = docenteCursoMDB.getNodosDocenteCurso();
        pesoMDB.getPesos(nodos, semestreActual);
    }

    /**
     * roo es para la evaporacion de las feromonas, es el porcentaje que
     * deseamos que desaparezca
     *
     * @param roo
     */
    public void crearHorario(double roo) {
        try {
//            for (int i = 0; i < constantes.iteraciones; i++) {
            for (int i = 0; i < 25; i++) {

                LinkedList<recorridoHormida> recorrido = new LinkedList<>();

//                for (int j = 0; j < constantes.hormigas; j++) {
                for (int j = 0; j < 25; j++) {
                    if (!nodosDisponibles.isEmpty()) {
                        nodosDisponibles.clear();
                    }
                    nodosDisponibles = docenteCursoMDB.getNodosDocenteCurso();

                    recorridoHormida caminoHormiga = new recorridoHormida();
                    int inicio = enteroAleatorio(0, (nodos.size() - 1));
//                    nodo nodoActual = buscarNodoConPosicionEnLista(nodos, inicio);
                    nodo nodoActual = buscarNodoConPosicionEnLista(nodos, 20);

                    while (!nodosDisponibles.isEmpty()) {
                        eliminarNodoDeLista(nodosDisponibles, nodoActual.getIdNodo());
                        if (!nodosDisponibles.isEmpty()) {
                            peso pesoAux = probabilidad(nodoActual, nodosDisponibles);
                            caminoHormiga.sumarLongitudCamino(pesoAux.peso);
                            caminoHormiga.agregarRecorrido(nodoActual);
                            nodoActual = pesoAux.nodoSiguiente;
                        }
                    }
                    recorrido.add(caminoHormiga);
                }
                evaporacionFeromonas(roo);
                enriquecerFeromonas(recorrido, obtenerMejorRecorrido(recorrido));
                recorridoCortos.add(obtenerMejorRecorridoLista(recorrido));
            }
            obtenerMejorRecorridoLista(recorridoCortos).imprimirRecorrido();
        } catch (InputsVaciosException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void enriquecerFeromonas(LinkedList<recorridoHormida> recorrido, double mayorRecorrido) {
        for (int i = 0; i < recorrido.size(); i++) {
            for (int j = 0; j < recorrido.get(i).getCamino().size(); j++) {
                for (int k = 0; k < recorrido.get(i).getCamino().get(j).getPesos().size(); k++) {
                    int nodoPesoSiguiente = recorrido.get(i).getCamino().get(j).getPesos().get(k).getNodoSiguiente().getIdNodo();
                    if ((j + 1) < recorrido.get(i).getCamino().size()) {
                        int nodoCaminoSiguiente = recorrido.get(i).getCamino().get((j + 1)).getIdNodo();
                        if (nodoPesoSiguiente == nodoCaminoSiguiente) {
                            double factor = recorrido.get(i).getLongitudRecorrido() / mayorRecorrido;
                            double nuevasFeromonas = recorrido.get(i).getCamino().get(j).getPesos().get(k).getFeromonas() * (1 + factor);
                            recorrido.get(i).getCamino().get(j).getPesos().get(k).setFeromonas(nuevasFeromonas);
                        }
                    }
                }
            }
        }
    }

    private double obtenerMejorRecorrido(LinkedList<recorridoHormida> lista) {
        double mejorValor = 0;
        for (recorridoHormida listaAux : lista) {
            if (listaAux.getLongitudRecorrido() > mejorValor) {
                mejorValor = listaAux.getLongitudRecorrido();
            }
        }
        return mejorValor;
    }

    private recorridoHormida obtenerMejorRecorridoLista(LinkedList<recorridoHormida> lista) {
        double mejorValor = 0;
        recorridoHormida mejorR = null;
        for (recorridoHormida listaAux : lista) {
            if (listaAux.LongitudRecorrido > mejorValor) {
                mejorValor = listaAux.LongitudRecorrido;
                mejorR = listaAux;
            }
        }
        return mejorR;
    }

    private void evaporacionFeromonas(double roo) {
        for (nodo nodo : nodos) {
            for (peso peso : nodo.getPesos()) {
                peso.setFeromonas(peso.getFeromonas() * (1 - roo));
            }
        }
    }

    //nodos disponibles es para verificar que el peso q se evalue no sea de un nodo ya recorrido
    private peso probabilidad(nodo calcNodo, LinkedList<nodo> nodDisponible) {
        peso nodoAux = null;
        double mejorProbabilidad = 0;
        double probabilidadGeneral = 0;

        for (peso pesoList : calcNodo.getPesos()) {
            probabilidadGeneral += (Math.pow(pesoList.getFeromonas(), constantes.alpha));
        }

        for (peso pesoAux : calcNodo.getPesos()) {
            if (nodoDisponiblePorID(nodDisponible, pesoAux.getNodoSiguiente().getIdNodo())) {
                double aux = ((Math.pow(pesoAux.getFeromonas(), constantes.alpha) * pesoAux.getPeso()) / probabilidadGeneral);
                if (aux > mejorProbabilidad) {
                    nodoAux = pesoAux;
                    mejorProbabilidad = aux;
                }
            }
        }

        return nodoAux;
    }

    private nodo buscarNodoConPosicionEnLista(LinkedList<nodo> listaNodos, int posicion) {
        return listaNodos.get(posicion);
    }

    private boolean nodoDisponiblePorID(LinkedList<nodo> listaNodos, int codigo) {
        for (nodo listaNodo : listaNodos) {
            if (listaNodo.getIdNodo() == codigo) {
                return true;
            }
        }
        return false;
    }

    private boolean eliminarNodoDeLista(LinkedList<nodo> listaNodos, int codigo) throws InputsVaciosException {
        for (int i = 0; i < listaNodos.size(); i++) {
            if (listaNodos.get(i).getIdNodo() == codigo) {
                listaNodos.remove(i);
                return true;
            }
        }
        throw new InputsVaciosException("No se ha encontrado el nodo \"" + codigo + "\" Para ser eliminado");
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
}
