package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class CarpetaPBT {

    @Property
    public void testObtenerPreVisualizacionProperty(String nombre) throws OperacionInvalida {
        Carpeta carpeta = new Carpeta(nombre);

        assertEquals(nombre, carpeta.obtenerPreVisualizacion());
    }
}
