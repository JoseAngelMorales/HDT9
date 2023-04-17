package HDT9;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PruebaA {

    @Test
    public void crearArbol(){
        Arbol arbol1 = new ArbolBinario(null);
        Arbol arbol2 = new SplayTree(null);
        Association<String, String> queso = new Association<String, String>("hola", "hello");
        Association<String, String> queso2 = new Association<String, String>("boca", "mouth");
        Association<String, String> queso3 = new Association<String, String>("lech", "milk");
        //Introduce los Association al arbol
        arbol1.empezar(queso);
        arbol1.empezar(queso2);
        arbol1.empezar(queso3);
        ((SplayTree) arbol2).insert(queso);
        ((SplayTree) arbol2).insert(queso2);
        ((SplayTree) arbol2).insert(queso3);
        //Evalue si la llave devuelve su valor asociado correctamente
        assertEquals("mouth", arbol1.empezarb("boca"));
        assertEquals("mouth", ((SplayTree) arbol2).bsplay(queso2.getLlave()));
    }
}
