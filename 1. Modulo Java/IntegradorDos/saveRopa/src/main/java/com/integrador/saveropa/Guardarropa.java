package com.integrador.saveropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardarropa {
    private Map<Integer, List<Prenda>> diccionario = new HashMap<>();
    private int contador;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        Integer idPrenda = ++contador;
        diccionario.put(idPrenda, listaDePrenda);
        return idPrenda;
    }

    public void mostrarPrendas(){
        diccionario.forEach((k,l)->{
            System.out.println("idGuardarropa: " + k);
            l.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }

}