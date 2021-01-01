package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.*;

public class CarpetaLimitadaTest {

    @Test
    public void testObtenerNoLeidos() throws OperacionInvalida {
        Carpeta carpeta = new Carpeta("carpetaLimitada");
        Carpeta carpeta2 = new Carpeta("carpetaLimitada2");
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 2);
        CarpetaLimitada carpetaLimitada2 = new CarpetaLimitada(carpeta2, 2);

        carpetaLimitada.añadir(carpetaLimitada2);
        carpetaLimitada.establecerLeido(true);

        assertEquals(0, carpetaLimitada.obtenerNoLeidos());
    }

    @Test
    public void testObtenerTamaño() throws OperacionInvalida {
        Carpeta carpeta = new Carpeta("carpetaLimitada");
        Carpeta carpeta2 = new Carpeta("carpetaLimitada2");
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 2);
        CarpetaLimitada carpetaLimitada2 = new CarpetaLimitada(carpeta2, 2);

        carpetaLimitada.añadir(carpetaLimitada2);

        assertEquals(0, carpetaLimitada.obtenerTamaño());
    }

    @Test
    public void testObtenerIcono() {
        Carpeta carpeta = new Carpeta("carpetaLimitada");
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 2);

        assertEquals((Integer) 1, carpetaLimitada.obtenerIcono());
    }

    @Test
    public void testObtenerPreVisualizacion() {
        Carpeta carpeta = new Carpeta("carpetaLimitada");
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 2);

        assertEquals("carpetaLimitada", carpetaLimitada.obtenerPreVisualizacion());
    }

    @Test
    public void testObtenerVisualizacion() throws OperacionInvalida {
        Texto texto = new Texto("texto","frases");
        Mensaje mensaje = new Mensaje(texto);
        Carpeta carpeta = new Carpeta("carpetaLimitada");
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 2);

        carpetaLimitada.añadir(mensaje);

        assertEquals("carpetaLimitada (1)", carpetaLimitada.obtenerVisualizacion());
    }

    @Test
    public void testObtenerRuta() throws OperacionInvalida {
        Carpeta carpeta = new Carpeta("carpetaLimitada");
        Carpeta carpeta2 = new Carpeta("carpetaLimitada2");
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 2);
        CarpetaLimitada carpetaLimitada2 = new CarpetaLimitada(carpeta2, 2);

        carpetaLimitada.añadir(carpetaLimitada2);

        assertEquals("carpetaLimitada", carpetaLimitada.obtenerRuta());
    }

    @Test
    public void testExplorar() throws OperacionInvalida {
        Texto texto = new Texto("texto","frases");
        Mensaje mensaje = new Mensaje(texto);
        Carpeta carpeta = new Carpeta("carpetaLimitada");
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 2);

        carpetaLimitada.añadir(mensaje);

        Collection expected = new Vector();
        expected.add(mensaje);

        assertEquals(expected, carpetaLimitada.explorar());
    }

    @Test
    public void testEliminar() throws OperacionInvalida {
        Texto texto = new Texto("texto","frases");
        Mensaje mensaje = new Mensaje(texto);
        Carpeta carpeta = new Carpeta("carpetaLimitada");
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 2);

        carpetaLimitada.añadir(mensaje);
        carpetaLimitada.eliminar(mensaje);

        assertTrue(carpetaLimitada.explorar().isEmpty());
    }

    @Test
    public void testObtenerHijo() throws OperacionInvalida {
        Carpeta carpeta = new Carpeta("carpetaLimitada");
        Carpeta carpeta2 = new Carpeta("carpetaLimitada2");
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 2);
        CarpetaLimitada carpetaLimitada2 = new CarpetaLimitada(carpeta2, 2);

        carpetaLimitada.añadir(carpetaLimitada2);

        assertEquals(carpetaLimitada2, carpetaLimitada.obtenerHijo(0));
    }

    @Test
    public void testBuscar() throws OperacionInvalida {
        Texto texto = new Texto("texto","frases");
        Mensaje mensaje = new Mensaje(texto);
        Carpeta carpeta = new Carpeta("carpetaLimitada");
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 2);

        carpetaLimitada.añadir(mensaje);

        Collection expected = new Vector();
        expected.add(mensaje);

        assertEquals(expected, carpetaLimitada.buscar("frases"));
    }
}
