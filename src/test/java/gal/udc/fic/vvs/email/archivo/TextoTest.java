package gal.udc.fic.vvs.email.archivo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextoTest {

    @Test
    public void testObtenerNombre() {
        Texto texto = new Texto("Text", "Essay");

        assertEquals("Text", texto.obtenerNombre());
    }

    @Test
    public void testObtenerContenido() {
        Texto texto = new Texto("Text", "Essay");

        assertEquals("Essay", texto.obtenerContenido());
    }

    @Test
    public void testObtenerTamaño() {
        Texto texto = new Texto("Text", "Essay");

        assertEquals(5, texto.obtenerTamaño());
    }

    @Test
    public void testObtenerPreVisualizacion() {
        Texto texto = new Texto("Text", "Essay");

        assertEquals("Text(5 bytes, text/plain)", texto.obtenerPreVisualizacion());
    }
}
