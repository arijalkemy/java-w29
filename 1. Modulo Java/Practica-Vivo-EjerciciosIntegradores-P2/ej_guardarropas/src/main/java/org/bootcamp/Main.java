package org.bootcamp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("marca1", "modelo1");
        Prenda prenda2 = new Prenda("marca2", "modelo2");

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer codigo = guardaRopa.guardarPrendas(List.of(prenda1, prenda2));

        System.out.println("Codigo: " + codigo);
        guardaRopa.devolverPrendas(codigo).forEach(System.out::println);

        guardaRopa.guardarPrendas(List.of(prenda1, prenda2));

        guardaRopa.mostrarPrendas();

    }
}