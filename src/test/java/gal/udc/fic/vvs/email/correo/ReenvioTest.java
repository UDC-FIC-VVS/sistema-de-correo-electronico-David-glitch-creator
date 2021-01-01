package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReenvioTest {

    @Test
    public void testObtenerTamaño() {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);
        Reenvio reenvio = new Reenvio(mensaje, mensaje);

        assertEquals(12, reenvio.obtenerTamaño());
    }

    @Test
    public void testObtenerVisualizacion() {
        Texto texto = new Texto("texto", "frases");
        Mensaje mensaje = new Mensaje(texto);
        Reenvio reenvio = new Reenvio(mensaje, mensaje);

        assertEquals("frases\n\n---- Correo reenviado ----\n\nfrases\n---- Fin correo reenviado ----", reenvio.obtenerVisualizacion());
    }
}
