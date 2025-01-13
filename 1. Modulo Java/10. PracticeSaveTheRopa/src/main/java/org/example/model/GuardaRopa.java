package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int identificador;
    private Map<Integer, List<Prenda>> listaPrendas;

    public GuardaRopa() {
        this.identificador = 0;
        this.listaPrendas = new HashMap<>();
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Map<Integer, List<Prenda>> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(Map<Integer, List<Prenda>> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        listaPrendas.put(identificador,listaDePrenda);
        return identificador++;
    }

    public void mostrarPrendas() {
        listaPrendas.forEach((key, value) -> System.out.println("Identificador: " + key + "\n Valor: " + value.toString() + "\n"));
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return listaPrendas.getOrDefault(numero, new ArrayList<>());
    }
}
