package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Prototipo {

    public abstract List generarSerie(ArrayList lista);
    public Integer valorSiguiente(Integer numero){
        return numero;
    }
    public ArrayList reiniciarSerie(){
        return null;
    }
    public Integer valorInicialSerie(Integer numero){
        return numero;
    }
}
