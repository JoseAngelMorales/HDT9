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
        Association<String, String> queso4 = new Association<String, String>("sol", "sun");
        Association<String, String> queso5 = new Association<String, String>("luna", "moon");
        Association<String, String> queso6 = new Association<String, String>("juan", "lano");
        Association<String, String> queso7 = new Association<String, String>("pene", "penis");
        Association<String, String> queso8 = new Association<String, String>("dile", "say");

        //Introduce los Association al arbol
        arbol1.empezar(queso);
        arbol1.empezar(queso2);
        arbol1.empezar(queso3);
        ((SplayTree) arbol2).insert(queso);
        ((SplayTree) arbol2).insert(queso2);
        ((SplayTree) arbol2).insert(queso3);
        ((SplayTree) arbol2).insert(queso4);
        ((SplayTree) arbol2).insert(queso5);
        ((SplayTree) arbol2).insert(queso6);
        ((SplayTree) arbol2).insert(queso7);
        ((SplayTree) arbol2).insert(queso8);
        System.out.println(((SplayTree) arbol2).bsplay("hola"));
        //Evalue si la llave devuelve su valor asociado correctamente
        assertEquals("mouth", arbol1.empezarb("boca"));
        assertEquals("mouth", ((SplayTree) arbol2).bsplay(queso2.getLlave()));
        assertEquals("hello", ((SplayTree) arbol2).bsplay("hola"));
    }
}
