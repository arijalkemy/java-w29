package Contenedores;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> localizadores=new ArrayList<>();

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }
    public List<Localizador> obtenerTodos(){
       return localizadores;
    }
}
