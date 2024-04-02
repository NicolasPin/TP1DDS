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
        pdp = new Materia(1111, new ArrayList<>(), "pdp");
        sintaxis = new Materia(22222, new ArrayList<>(), "sintaxis ");
        ads = new Materia(3333, new ArrayList<>(), "Aads");
        dds = new Materia(4444, Arrays.asList(pdp, sintaxis, ads), "Diseño");
    }

    private Alumno crearAlumnoConMateriasAprobadas(Materia... materias) {
        return new Alumno("44051382", "Nico", Arrays.asList(materias));
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