package gal.udc.fic.vvs.email.archivo;

import org.junit.Test;

import static org.junit.Assert.*;

public class AudioTest {

    @Test
    public void testObtenerNombre() {
        Audio audio = new Audio("Sample1", "Sonidito");

        assertEquals("Sample1", audio.obtenerNombre());
    }

    @Test
    public void testObtenerContenido() {
        Audio audio = new Audio("Sample1", "Sonidito");

        assertEquals("Sonidito", audio.obtenerContenido());
    }

    @Test
    public void testObtenerTamaño() {
        Audio audio = new Audio("Sample1", "Sonidito");

        assertEquals(8, audio.obtenerTamaño());
    }

    @Test
    public void testObtenerPreVisualizacion() {
        Audio audio = new Audio("Sample1", "Sonidito");

        assertEquals("Sample1(8 bytes, audio/ogg)", audio.obtenerPreVisualizacion());
    }
}
