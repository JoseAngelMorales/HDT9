package HDT9;

public class ArbolT {
    
    Arbol arbol;
    
    //Crea un mapa y lo implementa segun la opcion que recibe del usuario
    public Arbol newArbol(int i){

        switch(i){
            case 1:
                arbol = new ArbolBinario(null);
            case 2:
                arbol = new SplayTree(null);
            case 3:
                
        }
        return arbol;   
    }
}
