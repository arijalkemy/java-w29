package org.example;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer,List<Prenda>> registros;
    private Integer contador;


    public GuardaRopa(HashMap<Integer, List<Prenda>> registros) {
        this.registros = registros;
        this.contador = 0;
    }
    public GuardaRopa() {
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        Integer currentContador= this.contador;
        registros.put(currentContador,listaDePrenda);
        updateContador();
        return currentContador;
    }

    public void mostrarPrendas(){
        registros.forEach((k,v)-> {
            System.out.println(String.valueOf(k) + v);
        });

    }

    public List<Prenda> devolverPrendas(Integer numero){
        return registros.get(numero);
    }
    public void updateContador(){
        this.contador++;
    }
}
