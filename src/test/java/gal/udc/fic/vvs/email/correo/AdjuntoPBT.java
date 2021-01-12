package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class AdjuntoPBT {

    @Property
    public void testObtenerTamañoProperty(String nombre_texto, String contenido_texto,
                                          String nombre_archivo, String contenido_archivo) {
        Texto contenido = new Texto(nombre_texto, contenido_texto);
        MensajeAbstracto mensaje = new Mensaje(contenido);

        Archivo archivo = new Imagen(nombre_archivo, contenido_archivo);
        Adjunto adjunto = new Adjunto(mensaje, archivo);

        assertEquals(contenido_texto.length() + contenido_archivo.length(), adjunto.obtenerTamaño());
    }
}
