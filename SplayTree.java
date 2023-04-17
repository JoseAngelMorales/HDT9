package HDT9;

public class SplayTree extends Arbol {

    public SplayTree(ArbolNodo root){
        super(root);
    }

    private ArbolNodo splay(ArbolNodo current, Association<String, String> palabra) {
        if (current == null || current.palabra.getLlave().compareTo(palabra.getLlave()) == 0) {
            return current;
        }
        if(current.palabra.getLlave().compareToIgnoreCase(palabra.getLlave()) > 0){
            if(current.left == null){
                return current;
            }
            if(current.left.palabra.getLlave().compareToIgnoreCase(palabra.getLlave()) > 0){
                current.left.left = splay(current.left.left, palabra);
                current = rotarDerecha(current);
            } else if(current.left.palabra.getLlave().compareToIgnoreCase(palabra.getLlave()) < 0){
                current.left.right = splay(current.left.right, palabra);
                if(current.left.right != null){
                    current.left = rotarIzquierda(current);
                }
            }

            return (current.left == null) ? current : rotarDerecha(current);
        } else {
            if(current.right == null){
                return current;
            }
            if(current.right.palabra.getLlave().compareToIgnoreCase(palabra.getLlave()) > 0){
                current.right.left = splay(current.right.left, palabra);
                if(current.right.left != null){
                    current.right = rotarDerecha(current.right);
                }
            } else if(current.right.palabra.getLlave().compareToIgnoreCase(palabra.getLlave()) < 0){
                current.right.right = splay(current.right.right, palabra);
                current = rotarIzquierda(current);
            }

            return (current.right == null) ? current : rotarIzquierda(current);
        }
    }

    private ArbolNodo rotarDerecha(ArbolNodo current){
        ArbolNodo newroot = current.left;
        current.left = newroot.right;
        newroot.right = current;
        return newroot;
    }

    private ArbolNodo rotarIzquierda(ArbolNodo current){
        ArbolNodo newroot = current.right;
        current.right = newroot.left;
        newroot.left = current;
        return newroot;
    }

    public void insertar(Association<String, String> palabra){
        if(root == null){
            root = new ArbolNodo(palabra);
            return;
        }

        root = splay(root, palabra);

        if(root.palabra.getLlave().compareToIgnoreCase(palabra.getLlave()) == 0){
            return;
        }

        ArbolNodo nodo = new ArbolNodo(palabra);

        if(root.palabra.getLlave().compareToIgnoreCase(palabra.getLlave()) > 0){
            nodo.right = root;
            nodo.left = root.left;
            root.left = null;
        } else {
            nodo.left = root;
            nodo.right = root.right;
            root.right = null;
        }

        root = nodo;
    }
}