package domain;

import java.util.List;

public class Alumno {
    public String legajo;
    public String nombre;
    public List<Materia> materiasAprobadas;

    public Alumno(String legajo, String nombre, List<Materia> materiasAprobadas) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.materiasAprobadas = materiasAprobadas;
    }
}
