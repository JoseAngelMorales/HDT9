package HDT9;

public class Arbol {

    protected ArbolNodo root;

    public Arbol(ArbolNodo root){
        this.root = root;
    }

    //Metodo recursivo que busca un espacio libre en el arbol binario para ingresar el objeto Association
    public ArbolNodo insertar(ArbolNodo current, Association<String, String> palabra){
        return current;
    }

    //Empieza la recursividad para meter un elemento en el arbol
    public void empezar(Association<String, String> palabra){
        
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

//Codigo inspirado de: https://www.baeldung.com/java-binary-tree