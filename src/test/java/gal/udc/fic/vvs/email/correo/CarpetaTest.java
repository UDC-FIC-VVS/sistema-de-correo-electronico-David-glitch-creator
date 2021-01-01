package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarpetaTest {

    @Test
    public void testEstablecerLeido() {
    }

    @Test
    public void testObtenerNoLeidos() throws OperacionInvalida {
        Carpeta carpeta = new Carpeta("carpeta");
        Carpeta carpeta2 = new Carpeta("carpeta2");

        carpeta.añadir(carpeta2);
        carpeta.establecerLeido(true);

        assertEquals(0, carpeta.obtenerNoLeidos());
    }

    @Test
    public void testObtenerTamaño() throws OperacionInvalida {
        Carpeta carpeta = new Carpeta("carpeta");
        Carpeta carpeta2 = new Carpeta("carpeta2");

        carpeta.añadir(carpeta2);

        assertEquals(0, carpeta.obtenerTamaño());
    }

    @Test
    public void testObtenerIcono() throws OperacionInvalida {
        Carpeta carpeta = new Carpeta("carpeta");

        assertEquals((Integer) 1, carpeta.obtenerIcono());
    }

    @Test
    public void testObtenerPreVisualizacion() throws OperacionInvalida {
        Carpeta carpeta = new Carpeta("carpeta");

        assertEquals("carpeta", carpeta.obtenerPreVisualizacion());
    }

    @Test
    public void testObtenerVisualizacion() throws OperacionInvalida {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);
        Carpeta carpeta = new Carpeta("carpeta");

        carpeta.añadir(mensaje);

        assertEquals("carpeta (1)", carpeta.obtenerVisualizacion());
    }

    @Test
    public void testExplorar() throws OperacionInvalida {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);
        Carpeta carpeta = new Carpeta("carpeta");

        carpeta.añadir(mensaje);

        Collection expected = new Vector();
        expected.add(mensaje);

        assertEquals(expected, carpeta.explorar());

        carpeta.eliminar(mensaje);

        assertTrue(carpeta.explorar().isEmpty());
    }

    @Test
    public void testBuscar() throws OperacionInvalida {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);
        Carpeta carpeta = new Carpeta("carpeta");

        carpeta.añadir(mensaje);

        Collection expected = new Vector();
        expected.add(mensaje);

        assertEquals(expected, carpeta.buscar("frases"));
    }

    @Test
    public void testObtenerHijo() throws OperacionInvalida {
        Carpeta carpeta = new Carpeta("carpeta");
        Carpeta carpeta2 = new Carpeta("carpeta2");

        carpeta.añadir(carpeta2);

        assertEquals(carpeta2, carpeta.obtenerHijo(0));
    }
}
