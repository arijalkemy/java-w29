package Contenedores;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> localizadores = new ArrayList<>();

    public void agregarLocalizador(Localizador localizador){
        this.localizadores.add(localizador);
    }
    public List<Localizador> obtenerTodos(){
       return localizadores;
    }
}
