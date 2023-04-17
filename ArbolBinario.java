package HDT9;

public class ArbolBinario extends Arbol{
    
    public ArbolBinario(ArbolNodo root){
        super(root);
    }

    //Metodo recursivo que busca un espacio libre en el arbol binario para ingresar el objeto Association
    public ArbolNodo insertar(ArbolNodo current, Association<String, String> palabra){
        if(current == null){
            return new ArbolNodo(palabra);
        }
        if(palabra.getLlave().compareToIgnoreCase(current.palabra.getLlave()) < 0){
            current.left = insertar(current.left, palabra);
        }
        else if (palabra.getLlave().compareToIgnoreCase(current.palabra.getLlave()) > 0){
            current.right = insertar(current.right, palabra);
        }
    
        return current;
        }
    
    //Empieza la recursividad para meter un elemento en el arbol
    public void empezar(Association<String, String> palabra){
        root = insertar(root, palabra);
    }
    
    //Metodo recursivo para comparar el valor de una key en el arbol con la palabra dada y que devuelva su valor asociado
    private String buscarNodo(ArbolNodo current, String palabra) {
        if (current == null) {
            return "";
        } 
        if (palabra.equalsIgnoreCase(current.palabra.getLlave())) {
            return current.palabra.getValor();
        } 
        return palabra.compareToIgnoreCase(current.palabra.getLlave()) < 0
          ? buscarNodo(current.left, palabra)
          : buscarNodo(current.right, palabra);
    }
    
    //Empieza la recursividad para buscar un elemento en el arbol
    public String empezarb(String palabra) {
        return buscarNodo(root, palabra);
    }
}
