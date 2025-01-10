package org.meli;

import org.meli.models.GuardaRopa;
import org.meli.models.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Nike", "Camiseta Deportiva");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón Deportivo");

        List<Prenda> listaDePrendas = new ArrayList<>();
        listaDePrendas.add(prenda1);
        listaDePrendas.add(prenda2);

        Integer codigo = guardaRopa.guardarPrendas(listaDePrendas);
        System.out.println("Prendas guardadas con el código: " + codigo);

        System.out.println("\nPrendas en el guardarropas:");
        guardaRopa.mostrarPrendas();

        List<Prenda> prendasRecuperadas = guardaRopa.devolverPrendas(codigo);
        System.out.println("\nPrendas con el código " + codigo + ": " + prendasRecuperadas);

        System.out.println("\nPrendas restantes en el guardarropas:");
        guardaRopa.mostrarPrendas();
    }
}