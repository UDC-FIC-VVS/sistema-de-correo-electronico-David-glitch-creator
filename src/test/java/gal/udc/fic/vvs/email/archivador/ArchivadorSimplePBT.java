package gal.udc.fic.vvs.email.archivador;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimplePBT {

    @Property
    public void testObtenerNombreProperty(String nombre, int espacio) {
        Archivador archivador = new ArchivadorSimple(nombre, espacio);

        assertEquals(nombre, archivador.obtenerNombre());
    }
}
