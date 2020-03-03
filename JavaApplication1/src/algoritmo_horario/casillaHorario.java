/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_horario;

import org.joda.time.LocalTime;

/**
 *
 * @author angelrg
 */
public class casillaHorario {
    int idSalon;
    LocalTime initHour;
    LocalTime endHour;
    int idCurso;
    int idDocente;
    int dia;

    public casillaHorario(int idSalon, LocalTime initHour, LocalTime endHour, int idCurso, int idDocente) {
        this.idSalon = idSalon;
        this.initHour = initHour;
        this.endHour = endHour;
        this.idCurso = idCurso;
        this.idDocente = idDocente;
    }

    public casillaHorario(int idSalon, LocalTime initHour, LocalTime endHour, int dia) {
        this.idSalon = idSalon;
        this.initHour = initHour;
        this.endHour = endHour;
        this.dia = dia;
    }

    public casillaHorario(int idSalon, LocalTime initHour, LocalTime endHour) {
        this.idSalon = idSalon;
        this.initHour = initHour;
        this.endHour = endHour;
    }
    
    public casillaHorario(String idSalon, String initHour, String endHour) {
        this.idSalon = Integer.parseInt(idSalon);
        this.initHour = LocalTime.parse(initHour);
        this.endHour = LocalTime.parse(endHour);
    }
    
    public casillaHorario clone(int dia){
        return new casillaHorario(this.idSalon, this.initHour, this.endHour, dia);
    }

    public casillaHorario() {
    }

    public int getIdSalon() {
        return idSalon;
    }

    public LocalTime getInitHour() {
        return initHour;
    }

    public void setInitHour(LocalTime initHour) {
        this.initHour = initHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
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

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}
