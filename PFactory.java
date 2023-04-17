package HDT9;

public class PFactory extends Namer{
    public PFactory(String s){

        //Busca la primera coma y guarda desde el inicio hasta la coma para la palabra en ingles
        int i = s.indexOf(",");
        pingles = s.substring(0, i).trim();
        pespanol = s.substring(i+1, s.length());

    }
}

