package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class ReenvioPBT {

    @Property
    public void testObtenerTamañoProperty(String nombre, String contenido) {
        Texto texto = new Texto(nombre, contenido);
        Mensaje mensaje = new Mensaje(texto);
        Reenvio reenvio = new Reenvio(mensaje, mensaje);

        assertEquals(contenido.length() * 2, reenvio.obtenerTamaño());
    }
}
