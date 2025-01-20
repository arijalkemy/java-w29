package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Prenda> misPrendas = new ArrayList<>();
        misPrendas.add(new Prenda("Kev","oversize"));
        misPrendas.add(new Prenda("Luq","oversize"));
        GuardaRopa guardaRopa = new GuardaRopa();

        Integer locacion = guardaRopa.guardarPrendas(misPrendas);
        System.out.println(locacion);

        System.out.println("Ver prendas por el numero: "+locacion);
        System.out.println(guardaRopa.devolverPrendas(locacion));
    }
}