package gal.udc.fic.vvs.email.archivo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImagenTest {

    @Test
    public void testObtenerNombre() {
        Imagen imagen = new Imagen("Image1", "Wallpaper");

        assertEquals("Image1", imagen.obtenerNombre());
    }

    @Test
    public void testObtenerContenido() {
        Imagen imagen = new Imagen("Image1", "Wallpaper");

        assertEquals("Wallpaper", imagen.obtenerContenido());
    }

    @Test
    public void testObtenerTamaño() {
        Imagen imagen = new Imagen("Image1", "Wallpaper");

        assertEquals(9, imagen.obtenerTamaño());
    }

    @Test
    public void testObtenerPreVisualizacion() {
        Imagen imagen = new Imagen("Image1", "Wallpaper");

        assertEquals("Image1(9 bytes, image/png)", imagen.obtenerPreVisualizacion());
    }
}
