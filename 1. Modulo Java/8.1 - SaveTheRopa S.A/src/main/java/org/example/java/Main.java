package org.example.java;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Nike", "Zapatillas");
        Prenda prenda2 = new Prenda("Adidas", "Remera");
        List<Prenda> listaDePrendas = new ArrayList<>();
        listaDePrendas.add(prenda1);
        listaDePrendas.add(prenda2);

        Prenda prenda3 = new Prenda("Fila", "Zapatillas");
        Prenda prenda4 = new Prenda("Adidas", "Musculosa");
        List<Prenda> listaDePrendas2 = new ArrayList<>();
        listaDePrendas2.add(prenda3);
        listaDePrendas2.add(prenda4);

        Integer codigo = guardaRopa.guardarPrendas(listaDePrendas);
        System.out.println("\nLa lista de prendas se guardo con el código: " + codigo);

        Integer codigo2 = guardaRopa.guardarPrendas(listaDePrendas2);
        System.out.println("\nLa lista de prendas se guardo con el código: " + codigo2);

        System.out.println("\nLas prendas guardadas son: ");
        guardaRopa.mostrarPrendas();

        List<Prenda> prenda = guardaRopa.devolverPrendas(1);
        System.out.println("\nLas prendas con el código " + 1 + " son: " + prenda);
    }
}