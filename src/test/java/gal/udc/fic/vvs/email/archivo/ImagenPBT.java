package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class ImagenPBT {

    @Property
    public void testObtenerContenidoProperty(String nombre, String contenido) {
        Imagen imagen = new Imagen(nombre, contenido);

        assertEquals(contenido, imagen.obtenerContenido());
    }
}
