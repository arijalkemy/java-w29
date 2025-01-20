package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    List<Producto> produtos = new ArrayList<>();

    public Distribuidora() {
        Perecedero galletitas = new Perecedero("galletitas",10.4f,1);
        Perecedero galletitas1 = new Perecedero("galletitas1",10.4f,3);
        Perecedero galletitas2 = new Perecedero("galletitas2",10.4f,4);
        Perecedero galletitas3= new Perecedero("galletitas3",10.4f,2);
        Perecedero galletitas4 = new Perecedero("galletitas4",10.4f,5);

        produtos.add(galletitas);
        produtos.add(galletitas1);
        produtos.add(galletitas2);
        produtos.add(galletitas3);
        produtos.add(galletitas4);

        NoPerecedero atun = new NoPerecedero("atun",20.4f,"Envasado");
        NoPerecedero atun1 = new NoPerecedero("atun1",20.4f,"Envasado");
        NoPerecedero atun2 = new NoPerecedero("atun2",20.4f,"Envasado");
        NoPerecedero atun3= new NoPerecedero("atun3",20.4f,"Envasado");
        NoPerecedero atun4 = new NoPerecedero("atun4",20.4f,"Envasado");
        produtos.add(atun);
        produtos.add(atun1);
        produtos.add(atun2);
        produtos.add(atun3);
        produtos.add(atun4);

        produtos.forEach(producto->System.out.println("El precio total de "+producto.getNombre()+" es "+producto.calcular(3)));


    }


}
