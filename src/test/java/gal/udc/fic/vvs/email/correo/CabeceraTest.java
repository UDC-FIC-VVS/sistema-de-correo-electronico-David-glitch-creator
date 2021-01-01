package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.*;

public class CabeceraTest {

    @Test
    public void testObtenerTamaño() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        assertEquals(17, cabecera.obtenerTamaño());
    }

    @Test
    public void testObtenerVisualizacion() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        assertEquals("nombre: valor\nfrases", cabecera.obtenerVisualizacion());
    }

    @Test
    public void testObtenerNoLeidos() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        assertEquals(1, cabecera.obtenerNoLeidos());

        cabecera.establecerLeido(true);

        assertEquals(0, cabecera.obtenerNoLeidos());
    }

    @Test
    public void testObtenerIcono() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        assertEquals((Integer) 3, cabecera.obtenerIcono());

        cabecera.establecerLeido(true);

        assertEquals((Integer) 2, cabecera.obtenerIcono());
    }

    @Test
    public void testObtenerPreVisualizacion() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        assertEquals("frases...", cabecera.obtenerPreVisualizacion());
    }

    @Test
    public void testObtenerRuta() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        assertEquals("frases...", cabecera.obtenerRuta());
    }

    @Test(expected = OperacionInvalida.class)
    public void testExplorar() throws OperacionInvalida {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        cabecera.explorar();
    }

    @Test
    public void testBuscar() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        Collection expected = new Vector();
        expected.add(cabecera);

        assertEquals(expected, cabecera.buscar("frases"));
    }

    @Test(expected = OperacionInvalida.class)
    public void testAñadir() throws OperacionInvalida {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        Correo añadido = new Mensaje(contenido);

        cabecera.añadir(añadido);
    }

    @Test(expected = OperacionInvalida.class)
    public void testEliminar() throws OperacionInvalida {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        Correo añadido = new Mensaje(contenido);

        cabecera.eliminar(añadido);
    }

    @Test(expected = OperacionInvalida.class)
    public void testObtenerHijo() throws OperacionInvalida {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        cabecera.obtenerHijo(0);
    }

    @Test
    public void testObtenerPadre() {
        Texto contenido = new Texto("texto", "frases");
        MensajeAbstracto mensaje = new Mensaje(contenido);
        String nombre = "nombre";
        String valor = "valor";
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        Correo padre = new Mensaje(contenido);

        assertTrue(cabecera.obtenerPadre()==null);

        cabecera.establecerPadre(padre);

        assertEquals(padre, cabecera.obtenerPadre());
    }
}
