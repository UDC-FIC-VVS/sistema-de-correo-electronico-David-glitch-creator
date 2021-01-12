package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class CabeceraPBT {

    @Property
    public void testObtenerTamañoProperty(String nombre_texto, String contenido_texto, String nombre, String valor) {
        Texto contenido = new Texto(nombre_texto, contenido_texto);
        MensajeAbstracto mensaje = new Mensaje(contenido);
        Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

        assertEquals(contenido_texto.length() + nombre.length() + valor.length(), cabecera.obtenerTamaño());
    }
}
