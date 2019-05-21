/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_horario;

import org.joda.time.DateTime;

/**
 *
 * @author angelrg
 */
public class casillaHorario {
    int idSalon;
    DateTime initHour;
    DateTime endHour;
    int idCurso;
    int idDocente;

    public casillaHorario(int idSalon, DateTime initHour, DateTime endHour, int idCurso, int idDocente) {
        this.idSalon = idSalon;
        this.initHour = initHour;
        this.endHour = endHour;
        this.idCurso = idCurso;
        this.idDocente = idDocente;
    }

    public casillaHorario() {
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public DateTime getInitHour() {
        return initHour;
    }

    public void setInitHour(DateTime initHour) {
        this.initHour = initHour;
    }

    public DateTime getEndHour() {
        return endHour;
    }

    public void setEndHour(DateTime endHour) {
        this.endHour = endHour;
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
}
