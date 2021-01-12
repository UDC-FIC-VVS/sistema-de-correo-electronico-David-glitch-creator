package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class TextoPBT {

    @Property
    public void testObtenerTamañoProperty(String nombre, String contenido) {
        Texto texto = new Texto(nombre, contenido);

        assertEquals(contenido.length(), texto.obtenerTamaño());
    }
}
