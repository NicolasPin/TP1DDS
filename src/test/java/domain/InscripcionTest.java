package domain;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class InscripcionTest {

    private final Materia pdp;
    private final Materia sintaxis;
    private final Materia ads;
    private final Materia dds;

    public InscripcionTest() {
        pdp = new Materia(134534, new ArrayList<>(), "Paradigmas De la Programacion");
        sintaxis = new Materia(223423, new ArrayList<>(), "Sintaxis Y Semantica de la Programacion ");
        ads = new Materia(376545, new ArrayList<>(), "Analisis de Sistemas");
        dds = new Materia(476867, Arrays.asList(pdp, sintaxis, ads), "Diseño de Sistemas");
    }

    private Alumno crearAlumnoConMateriasAprobadas(Materia... materias) {
        return new Alumno("123", "Juan", Arrays.asList(materias));
    }

    @Test
    public void testTieneTodasLasCorrelativasAprobadas() {
        Alumno alumno = crearAlumnoConMateriasAprobadas(pdp, sintaxis, ads);
        List<Materia> materiasAInscribirse = Collections.singletonList(dds);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasAInscribirse);

        boolean resultado = inscripcion.aprobada();
        assertTrue(resultado);
    }

    @Test
    public void testNoTieneTodasLasCorrelativasAprobadas() {
        Alumno alumno = crearAlumnoConMateriasAprobadas(pdp, sintaxis);
        List<Materia> materiasAInscribirse = Collections.singletonList(dds);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasAInscribirse);

        boolean resultado = inscripcion.aprobada();
        assertFalse(resultado);
    }
}