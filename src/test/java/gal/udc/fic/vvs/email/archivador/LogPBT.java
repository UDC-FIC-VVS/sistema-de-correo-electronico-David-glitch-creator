package gal.udc.fic.vvs.email.archivador;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class LogPBT {

    @Property
    public void testObtenerEspacioDisponibleProperty(String nombre, int espacio) {
        Archivador decorado = new ArchivadorSimple(nombre, espacio);
        Log log = new Log(decorado);

        assertEquals(espacio, log.obtenerEspacioDisponible());
    }
}
