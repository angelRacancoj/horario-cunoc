/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManager;

/**
 *
 * @author angelrg
 */
public class queries {

    public static final String curso_dias = "SELECT c.id_curso AS ID, c.nombre_curso AS nombre, d.lunes AS lunes,"
            + "d.martes AS martes, d.miercoles AS miercoles, d.jueves AS jueves, d.viernes AS viernes,"
            + "c.cantidad_alumnos AS alumnos FROM CURSO AS c JOIN DIAS_CLASES AS d WHERE c.id_curso = d.CURSO_id";

    public static final String salones = "SELECT id_salon AS ID, nombre_salon AS nombre,"
            + "capacidad_alumnos AS capacidad FROM SALON";

    public static final String DOCENTE_CURSO = "SELECT CURSO_id, DOCENTE_id FROM PREFERENCIA_DOCENTE_CURSO";

    public static final String PESOS = "SELECT CC1.CURSO_id AS ID,"
            + "CASE WHEN ((CC1.semestre = CC2.semestre) AND (CC1.CARRERA_id = CC2.CARRERA_id) AND (CC1.es_obligatorio = CC2.es_obligatorio)) THEN '3' ELSE "
            + "CASE WHEN ((CC1.semestre <> CC2.semestre) AND (CC1.CARRERA_id = CC2.CARRERA_id) AND (CC1.es_obligatorio = CC2.es_obligatorio)) THEN '2' ELSE "
            + "CASE WHEN ((CC1.semestre = CC2.semestre) AND (CC1.CARRERA_id <> CC2.CARRERA_id) AND (CC1.es_obligatorio = CC2.es_obligatorio)) THEN '2' ELSE "
            + "CASE WHEN ((CC1.semestre = CC2.semestre) AND (CC1.CARRERA_id = CC2.CARRERA_id) AND (CC1.es_obligatorio <> CC2.es_obligatorio)) THEN '2' ELSE "
            + "CASE WHEN ((CC1.semestre <> CC2.semestre) AND (CC1.CARRERA_id <> CC2.CARRERA_id) AND (CC1.es_obligatorio = CC2.es_obligatorio)) THEN '1' ELSE "
            + "CASE WHEN ((CC1.semestre = CC2.semestre) AND (CC1.CARRERA_id <> CC2.CARRERA_id) AND (CC1.es_obligatorio <> CC2.es_obligatorio)) THEN '1' ELSE "
            + "CASE WHEN ((CC1.semestre <> CC2.semestre) AND (CC1.CARRERA_id = CC2.CARRERA_id) AND (CC1.es_obligatorio <> CC2.es_obligatorio)) THEN '1' ELSE "
            + "CASE WHEN ((CC1.semestre <> CC2.semestre) AND (CC1.CARRERA_id <> CC2.CARRERA_id) AND (CC1.es_obligatorio <> CC2.es_obligatorio)) THEN '0' "
            + "END END END END END END END END AS peso "
            + "FROM CARRERA_CURSO AS CC1 JOIN CARRERA_CURSO AS CC2 "
            + "WHERE (CC1.CURSO_id <> CC2.CURSO_id) AND (CC2.CURSO_id = ?) ORDER BY peso DESC";
    
    public static final String HORARIO_SALON = "SELECT SALON_id_salon AS ID, hora_inicio AS inicio, hora_fin AS fin FROM HORARIO_SALON";

    public static final String CONSTANTES ="SELECT duracion_periodo_min AS min, hormigas, iteraciones, alpha, beta FROM PROPERTIES";
}
