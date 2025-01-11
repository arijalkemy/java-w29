package models;

import java.util.ArrayList;
import java.util.List;

public class Clase2 extends Prototipo{


    @Override
    public List generarSerie(ArrayList lista) {
        return lista;
    }

    @Override
    public Integer valorInicialSerie(Integer valor) {
        return valor;
    }

    @Override
    public Integer valorSiguiente(Integer valor) {
        return valor;
    }

    @Override
    public ArrayList reiniciarSerie() {
        ArrayList lista = new ArrayList();
        return lista;
    }
}
