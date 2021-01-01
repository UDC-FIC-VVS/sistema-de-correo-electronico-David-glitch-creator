package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArchivadorSimpleTest {

    @Test
    public void testObtenerNombre() {
        String nombre_archivador = "nombre_archivador";
        int espacio = 25;
        Archivador archivador = new ArchivadorSimple(nombre_archivador, espacio);

        assertEquals(archivador.obtenerNombre(), nombre_archivador);
    }

    @Test
    public void testAlmacenarCorreo() {
        String nombre_archivador = "nombre_archivador";
        int espacio = 25;
        Archivador archivador = new ArchivadorSimple(nombre_archivador, espacio);

        String nombre_texto = "Probas";
        String contenido = "Probando as probas :)";
        Texto texto = new Texto(nombre_texto, contenido);
        Correo correo = new Mensaje(texto);

        assertTrue(archivador.almacenarCorreo(correo));

        assertFalse(archivador.almacenarCorreo(correo));
    }

    @Test
    public void testObtenerEspacioTotal() {
        String nombre_archivador = "nombre_archivador";
        int espacio = 25;
        Archivador archivador = new ArchivadorSimple(nombre_archivador, espacio);

        assertEquals(archivador.obtenerEspacioTotal(), espacio);
    }

    @Test
    public void testObtenerEspacioDisponible() {
        String nombre_archivador = "nombre_archivador";
        int espacio = 25;
        Archivador archivador = new ArchivadorSimple(nombre_archivador, espacio);

        assertEquals(archivador.obtenerEspacioDisponible(), espacio);
    }

    @Test
    public void testObtenerDelegado() {
        String nombre_archivador = "nombre_archivador";
        int espacio = 25;
        Archivador archivador = new ArchivadorSimple(nombre_archivador, espacio);

        archivador.establecerDelegado(archivador);

        assertTrue(archivador.obtenerDelegado()==null);
    }

}
