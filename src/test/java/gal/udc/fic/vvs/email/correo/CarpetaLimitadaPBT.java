package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class CarpetaLimitadaPBT {

    @Property
    public void testObtenerPreVisualizacionProperty(String nombre, int tamaño) {
        Carpeta carpeta = new Carpeta(nombre);
        CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

        assertEquals(nombre, carpetaLimitada.obtenerPreVisualizacion());
    }
}
