package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogTest {

    @Test
    public void testAlmacenarCorreo() {
        Archivador decorado = new ArchivadorSimple("decorado", 10);
        Log log = new Log(decorado);

        Texto texto = new Texto("Probas", "Texto");
        Correo correo = new Mensaje(texto);

        assertTrue(log.almacenarCorreo(correo));
    }

    @Test
    public void testObtenerNombre() {
        Archivador decorado = new ArchivadorSimple("decorado", 7);
        Log log = new Log(decorado);

        assertEquals("decorado", log.obtenerNombre());
    }

    @Test
    public void testObtenerEspacioTotal() {
        Archivador decorado = new ArchivadorSimple("decorado", 7);
        Log log = new Log(decorado);

        assertEquals(7, log.obtenerEspacioTotal());
    }

    @Test
    public void testObtenerEspacioDisponible() {
        Archivador decorado = new ArchivadorSimple("decorado", 7);
        Log log = new Log(decorado);

        assertEquals(7, log.obtenerEspacioDisponible());
    }

    @Test
    public void testObtenerDelegado() {
        Archivador decorado = new ArchivadorSimple("decorado", 7);
        Log log = new Log(decorado);
        Archivador archivador = new ArchivadorSimple("archivador", 3);

        log.establecerDelegado(archivador);

        assertTrue(log.obtenerDelegado()==null);
    }
}
