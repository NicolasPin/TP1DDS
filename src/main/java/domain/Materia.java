package domain;

import java.util.List;

public class Materia {
    public Integer codigo;
    public List<Materia> correlativas;
    public String nombre;

    public Materia(Integer codigo, List<Materia> correlativas, String nombre) {
        this.codigo = codigo;
        this.correlativas = correlativas;
        this.nombre = nombre;
    }
}
