package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;

import static org.junit.Assert.*;

public class DelegadoTest {

    @Test
    public void testAlmacenarCorreo() {
        Archivador decorado = new ArchivadorSimple("decorado", 7);
        Texto texto = new Texto("Probas", "Texto");
        Correo correo = new Mensaje(texto);
        Delegado delegado = new Delegado(decorado);

        assertTrue(delegado.almacenarCorreo(correo));

        delegado.establecerDelegado(decorado);
        assertFalse(delegado.almacenarCorreo(correo));

    }

    @Test
    public void testObtenerDelegado() {
        Archivador decorado = new ArchivadorSimple("decorado", 7);
        Delegado delegado = new Delegado(decorado);
        Archivador archivador = new ArchivadorSimple("archivador", 3);

        delegado.establecerDelegado(archivador);

        assertEquals(archivador, delegado.obtenerDelegado());
    }

    @Test
    public void testObtenerNombre() {
        Archivador decorado = new ArchivadorSimple("decorado", 7);
        Delegado delegado = new Delegado(decorado);

        assertEquals("decorado", delegado.obtenerNombre());
    }

    @Test
    public void testObtenerEspacioTotal() {
        Archivador decorado = new ArchivadorSimple("decorado", 7);
        Delegado delegado = new Delegado(decorado);

        assertEquals(7, delegado.obtenerEspacioTotal());
    }

    @Test
    public void testObtenerEspacioDisponible() {
        Archivador decorado = new ArchivadorSimple("decorado", 7);
        Delegado delegado = new Delegado(decorado);

        assertEquals(7, delegado.obtenerEspacioDisponible());
    }

}
