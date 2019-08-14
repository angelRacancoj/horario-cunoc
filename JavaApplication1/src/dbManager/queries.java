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

    public static final String DOCENTE_CURSO = "SELECT id_p_d_c, CURSO_id, DOCENTE_id FROM PREFERENCIA_DOCENTE_CURSO";

    public static final String HORARIO_SALON = "SELECT SALON_id_salon AS ID, hora_inicio AS inicio, hora_fin AS fin FROM HORARIO_SALON";

    public static final String CONSTANTES = "SELECT duracion_periodo_min AS min, hormigas, iteraciones, alpha, beta FROM PROPERTIES";

    public static final String MISMO_SEMESTRE = "SELECT COUNT(*) FROM CARRERA_CURSO AS CC1 INNER JOIN CARRERA_CURSO AS CC2 ON (CC2.CURSO_id = ?) AND (CC1.CURSO_id = ?) AND (CC1.semestre = CC2.semestre)";

    public static final String DIFERENTE_CARRERA = "SELECT COUNT(*) FROM CARRERA_CURSO AS CC1 INNER JOIN CARRERA_CURSO AS CC2 ON (CC2.CURSO_id = ?) AND (CC1.CURSO_id = ?) AND (CC1.CARRERA_id <> CC2.CARRERA_id)";

    public static final String INTERSECCION_ENTRE_CURSOS = "SELECT COUNT(*) FROM CARRERA_CURSO AS CC1 INNER JOIN CARRERA_CURSO AS CC2 ON (CC2.CURSO_id = ?) AND (CC1.CURSO_id = ?)";

    public static final String SON_OBLIGATORIOS = "SELECT COUNT(*) FROM CARRERA_CURSO AS CC1 INNER JOIN CARRERA_CURSO AS CC2 ON "
            + "(CC2.CURSO_id = ?) AND (CC1.CURSO_id = ?) AND (CC1.es_obligatorio = CC2.es_obligatorio) AND (CC1.es_obligatorio = ?)";

    public static final String PROPORCION_ALUMNOS = "SELECT (cantidad_alumnos/(SELECT cantidad_alumnos FROM CURSO ORDER BY cantidad_alumnos DESC LIMIT 1)) AS Alumnos FROM CURSO WHERE (id_curso = ?)";

    public static final String PRIMER_SEMESTRE = "SELECT COUNT(*) FROM CARRERA_CURSO WHERE (CURSO_id = ?) AND (semestre%2 = 1)";

    public static final String SEGUNDO_SEMESTRE = "SELECT COUNT(*) FROM CARRERA_CURSO WHERE (CURSO_id = ?) AND (semestre%2 <> 1)";

}
