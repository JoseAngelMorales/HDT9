package HDT9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // Creating a new association, a new factory, a new scanner, and 6 new trees.
        Association<String, String> palabra = new Association<String,String>(null, null);
        Factory factory = new Factory();
        Scanner teclado = new Scanner(System.in);
        ArbolT tipo = new ArbolT();

        // Crear un nuevo arbol basado en el input del usuario
        int tipomapa = 0;
        String menu = "Bienvenido al programa, elija la opcion de implementacion\n1. BinaryTree\n2. SplayTree\n3. RBTree";
        System.out.println(menu);
        tipomapa = teclado.nextInt();
        teclado.nextLine();
        while(tipomapa < 1 || tipomapa > 3){
            System.out.println(menu);
            tipomapa = teclado.nextInt();
            teclado.nextLine();
        }

        Arbol arbolie = tipo.newArbol(tipomapa);

        try{
            BufferedReader reader = new BufferedReader(new FileReader("Spanish.txt"));
            String linea = reader.readLine();
            while(linea != null){
                Namer namer = factory.getNamer(linea);
                //Arbol Ingles-Espanol
                palabra.setLlave(namer.getPingles());
                palabra.setValor(namer.getPespanol());
                arbolie.empezar(palabra);
                palabra = new Association<String,String>(null, null);

                linea = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("No se ha encontrado la direccion del archivo.");
        }

        menu = "\nBienvenido al traductor, elija una de las opciones:\n1. Traducir del ingles\n2. Traducir un archivo .txt\n3. Cerrar el programa";
        int opcion = 0;
        while(opcion < 1 || opcion > 3){
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            while(opcion >= 1 && opcion < 3){
                switch(opcion){
                    case 1:{
                        System.out.println("\nIngrese la oracion a traducir: ");
                        String oracion = teclado.nextLine();
                        String traduccion = "";
                        int i = oracion.lastIndexOf(".");
                        //Quitar el punto al final de la oracion si lo tiene
                        if(i+1 == oracion.length()){
                            oracion = oracion.substring(0,i);
                        }
                        //Agregarle un espacio al final de la oracion para que funcione con el while
                        if(oracion.lastIndexOf(" ") != oracion.length()){
                            oracion = oracion + " ";
                        }
                        //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                        while(oracion != ""){
                            i = oracion.indexOf(" ");
                            String p = oracion.substring(0, i);
                            //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                            if(arbolie.empezarb(p) == ""){
                                traduccion = traduccion + "*" + p + "* ";
                            }
                            //Si la palabra si esta agrega el valor de la llave a la traduccion
                            else {
                                traduccion = traduccion + arbolie.empezarb(p) + " ";
                            }
                            oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                        }
                        //Mayuscula y punto
                        traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                        traduccion = traduccion.trim() + ".";
                        System.out.println("Traduccion: " + traduccion);
                        //Loop
                        System.out.println(menu);
                        opcion = teclado.nextInt();
                        teclado.nextLine();
                        break;
                    }
                    case 2:{
                        try{
                            System.out.println("\nNombre del archivo:");
                            String archivo = teclado.nextLine();
                            BufferedReader reader = new BufferedReader(new FileReader(archivo));
                            String linea = reader.readLine();
                            while(linea != null){
                                System.out.println("\nFrase a traducir: " + linea);
                                String oracion = linea;
                                String traduccion = "";
                                int i = oracion.lastIndexOf(".");
                                //Quitar el punto al final de la oracion si lo tiene
                                if(i+1 == oracion.length()){
                                    oracion = oracion.substring(0,i);
                                }
                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                    oracion = oracion + " ";
                                }
                                //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                while(oracion != ""){
                                    i = oracion.indexOf(" ");
                                    String p = oracion.substring(0, i);
                                    //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                    if(arbolie.empezarb(p) == ""){
                                        traduccion = traduccion + "*" + p + "* ";
                                    }
                                    //Si la palabra si esta agrega el valor de la llave a la traduccion
                                    else {
                                        traduccion = traduccion + arbolie.empezarb(p) + " ";
                                    }
                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                }
                                //Mayuscula y punto
                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                traduccion = traduccion.trim() + ".";
                                System.out.println("Traduccion: " + traduccion);
                                linea = reader.readLine();
                            }
                            opcion = 0;
                        } catch (IOException e) {
                            System.out.println("No se ha encontrado la direccion del archivo.");
                        }
                        break;
                    }
                }
            }
        }

    }
}