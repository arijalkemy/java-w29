package org.example;

import org.example.model.GuardaRopa;
import org.example.model.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Marca1", "Modelo1"));
        prendas.add(new Prenda("Marca2", "Modelo2"));
        prendas.add(new Prenda("Marca3", "Modelo3"));

        System.out.println(guardaRopa.guardarPrendas(prendas));
        System.out.println(guardaRopa.guardarPrendas(prendas));
        System.out.println(guardaRopa.guardarPrendas(prendas));

        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(0));
    }
}