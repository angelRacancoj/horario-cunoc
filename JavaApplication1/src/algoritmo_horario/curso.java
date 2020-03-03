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
    boolean Lunes;
    boolean Martes;
    boolean Miercoles;
    boolean Jueves;
    boolean Viernes;
    int totalAlumnos;
    int alumnosRestantes;

    public curso(int idCurso, String nombreCurso, boolean Lunes, boolean Martes, boolean Miercoles, boolean Jueves, boolean Viernes, int totalAlumnos) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.Lunes = Lunes;
        this.Martes = Martes;
        this.Miercoles = Miercoles;
        this.Jueves = Jueves;
        this.Viernes = Viernes;
        this.totalAlumnos = totalAlumnos;
        this.alumnosRestantes = totalAlumnos;
    }


    public curso(String idCurso, String nombreCurso, String Lunes, String Martes, String Miercoles, String Jueves, String Viernes, String totalAlumnos) {
        this.idCurso = Integer.parseInt(idCurso);
        this.nombreCurso = nombreCurso;
        this.Lunes = Boolean.getBoolean(Lunes);
        this.Martes = Boolean.getBoolean(Martes);
        this.Miercoles = Boolean.getBoolean(Miercoles);
        this.Jueves = Boolean.getBoolean(Jueves);
        this.Viernes = Boolean.getBoolean(Viernes);
        this.totalAlumnos = Integer.parseInt(totalAlumnos);
        this.alumnosRestantes = Integer.parseInt(totalAlumnos);
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

    public boolean isLunes() {
        return Lunes;
    }

    public void setLunes(boolean Lunes) {
        this.Lunes = Lunes;
    }

    public boolean isMartes() {
        return Martes;
    }

    public void setMartes(boolean Martes) {
        this.Martes = Martes;
    }

    public boolean isMiercoles() {
        return Miercoles;
    }

    public void setMiercoles(boolean Miercoles) {
        this.Miercoles = Miercoles;
    }

    public boolean isJueves() {
        return Jueves;
    }

    public void setJueves(boolean Jueves) {
        this.Jueves = Jueves;
    }

    public boolean isViernes() {
        return Viernes;
    }

    public void setViernes(boolean Viernes) {
        this.Viernes = Viernes;
    }

    public int getTotalAlumnos() {
        return totalAlumnos;
    }

    public void setTotalAlumnos(int totalAlumnos) {
        this.totalAlumnos = totalAlumnos;
    }

    public int getAlumnosRestantes() {
        return alumnosRestantes;
    }

    public void setAlumnosRestantes(int alumnosRestantes) {
        this.alumnosRestantes = alumnosRestantes;
    }
}
