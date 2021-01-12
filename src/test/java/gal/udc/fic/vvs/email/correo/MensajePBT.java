package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class MensajePBT {

    @Property
    public void testObtenerVisualizacionProperty(String nombre, String contenido) {
        Texto texto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(texto);

        assertEquals(contenido, mensaje.obtenerVisualizacion());
    }
}
