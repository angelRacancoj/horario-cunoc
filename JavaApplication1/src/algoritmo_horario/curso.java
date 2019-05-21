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
public class curso {
    int idCurso;
    String nombreCurso;
    int periodosLunes;
    int periodosMartes;
    int periodosMiercoles;
    int periodosJueves;
    int periodosViernes;

    public curso(int idCurso, String nombreCurso, int periodosLunes, int periodosMartes, int periodosMiercoles, int periodosJueves, int periodosViernes) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.periodosLunes = periodosLunes;
        this.periodosMartes = periodosMartes;
        this.periodosMiercoles = periodosMiercoles;
        this.periodosJueves = periodosJueves;
        this.periodosViernes = periodosViernes;
    }

    public curso() {
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getPeriodosLunes() {
        return periodosLunes;
    }

    public void setPeriodosLunes(int periodosLunes) {
        this.periodosLunes = periodosLunes;
    }

    public int getPeriodosMartes() {
        return periodosMartes;
    }

    public void setPeriodosMartes(int periodosMartes) {
        this.periodosMartes = periodosMartes;
    }

    public int getPeriodosMiercoles() {
        return periodosMiercoles;
    }

    public void setPeriodosMiercoles(int periodosMiercoles) {
        this.periodosMiercoles = periodosMiercoles;
    }

    public int getPeriodosJueves() {
        return periodosJueves;
    }

    public void setPeriodosJueves(int periodosJueves) {
        this.periodosJueves = periodosJueves;
    }

    public int getPeriodosViernes() {
        return periodosViernes;
    }

    public void setPeriodosViernes(int periodosViernes) {
        this.periodosViernes = periodosViernes;
    }
}
