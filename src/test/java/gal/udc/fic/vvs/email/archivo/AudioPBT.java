package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class AudioPBT {

    @Property
    public void testObtenerNombreProperty(String nombre, String contenido) {
        Audio audio = new Audio(nombre, contenido);

        assertEquals(nombre, audio.obtenerNombre());
    }
}
