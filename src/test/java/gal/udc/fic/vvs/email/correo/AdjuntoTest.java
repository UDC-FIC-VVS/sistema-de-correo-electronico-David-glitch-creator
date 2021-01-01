package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.*;

public class AdjuntoTest {

    @Test
    public void testObtenerTamaño() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        assertEquals(10, adjunto.obtenerTamaño());
    }

    @Test
    public void testObtenerVisualizacion() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        assertEquals("frases\n\nAdxunto: imagen(4 bytes, image/png)", adjunto.obtenerVisualizacion());
    }

    @Test
    public void testObtenerNoLeidos() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        assertEquals(1, adjunto.obtenerNoLeidos());

        adjunto.establecerLeido(true);

        assertEquals(0, adjunto.obtenerNoLeidos());
    }

    @Test
    public void testObtenerIcono() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        assertEquals((Integer) 3, adjunto.obtenerIcono());

        adjunto.establecerLeido(true);

        assertEquals((Integer) 2, adjunto.obtenerIcono());
    }

    @Test
    public void testObtenerPreVisualizacion() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        assertEquals("frases...", adjunto.obtenerPreVisualizacion());
    }

    @Test
    public void testObtenerRuta() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        assertEquals("frases...", adjunto.obtenerRuta());
    }

    @Test(expected = OperacionInvalida.class)
    public void testExplorar() throws OperacionInvalida {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        adjunto.explorar();
    }

    @Test
    public void testBuscar() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        Collection expected = new Vector();
        expected.add(adjunto);

        assertEquals(expected, adjunto.buscar("frases"));
    }

    @Test(expected = OperacionInvalida.class)
    public void testAñadir() throws OperacionInvalida {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        Correo añadido = new Mensaje(contenido);

        adjunto.añadir(añadido);
    }

    @Test(expected = OperacionInvalida.class)
    public void testEliminar() throws OperacionInvalida {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        Correo añadido = new Mensaje(contenido);

        adjunto.eliminar(añadido);
    }

    @Test(expected = OperacionInvalida.class)
    public void testObtenerHijo() throws OperacionInvalida {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        adjunto.obtenerHijo(0);
    }

    @Test
    public void testObtenerPadre() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen("imagen", "foto");
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        Correo padre = new Mensaje(contenido);

        assertTrue(adjunto.obtenerPadre()==null);

        adjunto.establecerPadre(padre);

        assertEquals(padre, adjunto.obtenerPadre());
    }
}
