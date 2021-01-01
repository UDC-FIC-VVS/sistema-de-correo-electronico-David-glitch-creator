package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.*;

public class MensajeTest {

    @Test
    public void testObtenerNoLeidos() {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);

        assertEquals(1, mensaje.obtenerNoLeidos());

        mensaje.establecerLeido(true);

        assertEquals(0, mensaje.obtenerNoLeidos());
    }

    @Test
    public void testObtenerTamaño() {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);

        assertEquals(6, mensaje.obtenerTamaño());
    }

    @Test
    public void testObtenerIcono() {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);

        assertEquals((Integer) 3, mensaje.obtenerIcono());

        mensaje.establecerLeido(true);

        assertEquals((Integer) 2, mensaje.obtenerIcono());
    }

    @Test
    public void testObtenerPreVisualizacion() {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);

        assertEquals("frases...", mensaje.obtenerPreVisualizacion());
    }

    @Test
    public void testObtenerVisualizacion() {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);

        assertEquals("frases", mensaje.obtenerVisualizacion());
    }

    @Test
    public void testBuscar() {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);

        Collection expected = new Vector();
        expected.add(mensaje);

        assertEquals(expected, mensaje.buscar("frases"));
    }
}
